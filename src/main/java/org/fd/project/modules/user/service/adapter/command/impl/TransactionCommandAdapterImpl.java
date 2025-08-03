package org.fd.project.modules.user.service.adapter.command.impl;

import lombok.RequiredArgsConstructor;
import org.fd.project.modules.user.model.entity.SavingsAccountTransaction;
import org.fd.project.modules.user.model.repository.SavingsAccountTransactionRepository;
import org.fd.project.modules.user.service.adapter.command.TransactionCommandAdapter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionCommandAdapterImpl implements TransactionCommandAdapter {

    private final SavingsAccountTransactionRepository savingsAccountTransactionRepository;

    @Override
    public SavingsAccountTransaction save(SavingsAccountTransaction savingsAccountTransaction) {
        return savingsAccountTransactionRepository.save(savingsAccountTransaction);
    }
}
