package org.fd.project.modules.user.service.adapter.query;

import org.fd.project.modules.user.model.entity.PaymentType;
import org.fd.project.modules.user.model.entity.SavingsAccount;

import java.util.Optional;

public interface TransactionQueryAdapter {

    Optional<SavingsAccount> findSavingsAccount(String accountNumber, String accountName);

    Optional<PaymentType> findPaymentType(String paymentType);

}
