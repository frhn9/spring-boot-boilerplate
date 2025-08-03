package org.fd.project.modules.user.service.adapter.command;

import org.fd.project.modules.user.model.entity.SavingsAccountTransaction;

public interface TransactionCommandAdapter {
    SavingsAccountTransaction save(SavingsAccountTransaction savingsAccountTransaction);
}
