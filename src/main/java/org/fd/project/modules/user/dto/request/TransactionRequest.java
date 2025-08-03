package org.fd.project.modules.user.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionRequest {

    private String accountNumber;

    private String accountName;

    private BigDecimal transactionAmount;

    private String paymentType;

    private String bankNumber;

    private String routingCode;

    private String receiptNumber;

}
