package org.fd.project.modules.user.service.core.impl;

import lombok.RequiredArgsConstructor;
import org.fd.project.modules.user.dto.request.TransactionRequest;
import org.fd.project.modules.user.dto.response.TransactionResponse;
import org.fd.project.modules.user.exception.BalanceInsufficientException;
import org.fd.project.modules.user.exception.PaymentTypeNotFoundException;
import org.fd.project.modules.user.exception.SavingsAccountNotFoundException;
import org.fd.project.modules.user.exception.UserBlockedByBankException;
import org.fd.project.modules.user.mapper.TransactionMapper;
import org.fd.project.modules.user.model.entity.PaymentDetail;
import org.fd.project.modules.user.model.entity.PaymentType;
import org.fd.project.modules.user.model.entity.SavingsAccount;
import org.fd.project.modules.user.model.entity.SavingsAccountTransaction;
import org.fd.project.modules.user.service.adapter.command.PaymentDetailCommandAdapter;
import org.fd.project.modules.user.service.adapter.command.TransactionCommandAdapter;
import org.fd.project.modules.user.service.adapter.query.TransactionQueryAdapter;
import org.fd.project.modules.user.service.core.TransactionService;
import org.springframework.core.task.TaskExecutor;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;

import static org.fd.project.modules.user.utils.TransactionValidationHelper.validateBalance;
import static org.fd.project.modules.user.utils.TransactionValidationHelper.validateBlockedUser;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionQueryAdapter transactionQueryAdapter;
    private final TransactionCommandAdapter transactionCommandAdapter;
    private final PaymentDetailCommandAdapter paymentDetailCommandAdapter;

    private final TransactionMapper transactionMapper;

    private final TaskExecutor processExecutor;
    private final TaskExecutor virtualThreadExecutor;

    @Override
    @Transactional(timeout = 5, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    @Retryable(
            retryFor = {SQLException.class, PessimisticLockingFailureException.class},
            maxAttempts = 5,
            backoff = @Backoff(delay = 100)
    )
    public TransactionResponse processTransaction(TransactionRequest transactionRequest) {
        CompletableFuture<SavingsAccount> savingsAccountFuture = CompletableFuture.supplyAsync(() ->
                transactionQueryAdapter.findSavingsAccount(transactionRequest.getAccountNumber(), transactionRequest.getAccountName())
                        .orElseThrow(SavingsAccountNotFoundException::new), processExecutor);
        CompletableFuture<PaymentType> paymentTypeFuture = CompletableFuture.supplyAsync(() ->
                transactionQueryAdapter.findPaymentType(transactionRequest.getPaymentType())
                        .orElseThrow(PaymentTypeNotFoundException::new), processExecutor);

        SavingsAccount savingsAccount = savingsAccountFuture.join();
        PaymentType paymentType = paymentTypeFuture.join();

        CompletableFuture<Void> validateBlockedUserProcess = CompletableFuture.runAsync(() ->
                        validateBlockedUser(savingsAccount.isBlockedByBank()),
                virtualThreadExecutor
        );
        CompletableFuture<Void> validateBalanceProcess = CompletableFuture.runAsync(() ->
                        validateBalance(savingsAccount.getAccountBalanceDerived(), transactionRequest.getTransactionAmount()),
                virtualThreadExecutor
        );
        CompletableFuture.allOf(validateBlockedUserProcess, validateBalanceProcess).join();

        SavingsAccountTransaction transaction = transactionMapper.populateTransaction(transactionRequest, savingsAccount);
        CompletableFuture<SavingsAccountTransaction> transactionFuture = saveTransactionAsync(transaction);
        CompletableFuture<Void> paymentDetailFuture = savePaymentDetailAsync(transactionRequest, paymentType, savingsAccount);
        CompletableFuture.allOf(transactionFuture, paymentDetailFuture).join();

        return new TransactionResponse(transaction.getTransactionId());
    }

    private CompletableFuture<SavingsAccountTransaction> saveTransactionAsync(SavingsAccountTransaction transaction) {
        return CompletableFuture.supplyAsync(() -> transactionCommandAdapter.save(transaction), processExecutor);
    }

    private CompletableFuture<Void> savePaymentDetailAsync(TransactionRequest transactionRequest, PaymentType paymentType, SavingsAccount savingsAccount) {
        return CompletableFuture.runAsync(() -> {
            PaymentDetail paymentDetail = transactionMapper.populatePaymentDetail(transactionRequest, paymentType, savingsAccount.getAccountNumber());
            paymentDetailCommandAdapter.save(paymentDetail);
        }, processExecutor);
    }

}