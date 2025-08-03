package org.fd.project.modules.user.model.repository;

import org.fd.project.modules.user.model.entity.SavingsAccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsAccountTransactionRepository extends JpaRepository<SavingsAccountTransaction, Long> {
}
