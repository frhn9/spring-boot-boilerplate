package org.fd.project.modules.user.mapper;

import org.fd.project.modules.user.dto.request.TransactionRequest;
import org.fd.project.modules.user.model.entity.PaymentDetail;
import org.fd.project.modules.user.model.entity.PaymentType;
import org.fd.project.modules.user.model.entity.SavingsAccount;
import org.fd.project.modules.user.model.entity.SavingsAccountTransaction;
import org.fd.project.modules.user.utils.TransactionHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = TransactionHelper.class)
public interface TransactionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "transactionId", expression = "java(TransactionUtils.createTransactionId(savingsAccount.getExternalId()))")
    @Mapping(target = "runningBalanceDerived", expression = "java(TransactionUtils.calculateRunningBalance(savingsAccount.getAccountBalanceDerived(), transactionRequest.getTransactionAmount()))")
    @Mapping(target = "transactionDateTime", ignore = true)
    @Mapping(target = "amount", source = "transactionRequest.transactionAmount")
    SavingsAccountTransaction populateTransaction(TransactionRequest transactionRequest, SavingsAccount savingsAccount);

    @Mapping(target = "routingCode", source = "transactionRequest.routingCode")
    @Mapping(target = "bankNumber", source = "transactionRequest.bankNumber")
    @Mapping(target = "receiptNumber", source = "transactionRequest.receiptNumber")
    @Mapping(target = "paymentType", source = "paymentType")
    @Mapping(target = "accountNumber", source = "accountNumber")
    PaymentDetail populatePaymentDetail(TransactionRequest transactionRequest, PaymentType paymentType, String accountNumber);

}
