package org.fd.project.modules.user.model.repository;

import jakarta.persistence.LockModeType;
import org.fd.project.modules.user.model.entity.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface SavingsAccountRepository extends JpaRepository<SavingsAccount, Long> {

    @Query(value = """
            SELECT sa.account_number as accountNumber, sa.account_name as accountName, sa.external_id as externalId, sa.account_balance_derived as accountBalanceDerived
            FROM savings_account sa where sa.account_number = :accountNumber and sa.account_name = :accountName
            """)
    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<SavingsAccount> findByAccountNumber(
            @Param("accountNumber") String accountNumber,
            @Param("accountName") String accountName
    );

}