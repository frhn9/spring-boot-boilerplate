package org.fd.project.modules.user.service.core;

import org.fd.project.modules.user.dto.request.TransactionRequest;
import org.fd.project.modules.user.dto.response.TransactionResponse;

public interface TransactionService {

    TransactionResponse processTransaction(TransactionRequest transactionRequest);

}
