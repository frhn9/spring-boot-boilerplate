package org.fd.project.modules.user.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Table(name = "savings_account_transaction")
@Getter
@Setter
public class SavingsAccountTransaction {

    @Id
    private Long id;

    private String transactionId;

    private BigDecimal amount;

    private BigDecimal runningBalanceDerived;

    @CreatedDate
    private ZonedDateTime transactionDateTime;

    @ManyToOne
    @JoinColumn(name = "savings_account_id", nullable = false)
    private SavingsAccount savingsAccount;

}
