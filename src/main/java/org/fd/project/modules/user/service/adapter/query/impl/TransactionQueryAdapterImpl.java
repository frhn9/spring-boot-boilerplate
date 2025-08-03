package org.fd.project.modules.user.service.adapter.query.impl;

import lombok.RequiredArgsConstructor;
import org.fd.project.modules.user.model.entity.PaymentType;
import org.fd.project.modules.user.model.repository.PaymentTypeRepository;
import org.fd.project.modules.user.model.repository.SavingsAccountRepository;
import org.fd.project.modules.user.service.adapter.query.TransactionQueryAdapter;
import org.fd.project.modules.user.model.entity.SavingsAccount;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionQueryAdapterImpl implements TransactionQueryAdapter {

    private final SavingsAccountRepository savingsAccountRepository;

    private final PaymentTypeRepository paymentTypeRepository;

    @Override
    public Optional<SavingsAccount> findSavingsAccount(String accountNumber, String accountName) {
        return savingsAccountRepository.findByAccountNumber(accountNumber, accountName);
    }

    @Override
    public Optional<PaymentType> findPaymentType(String paymentType) {
        return paymentTypeRepository.findByName(paymentType);
    }

}
