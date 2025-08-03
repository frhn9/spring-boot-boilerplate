package org.fd.project.modules.user.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "savings_account")
@Getter
@Setter
public class SavingsAccount {

    @Id
    private Long id;

    private String accountNumber;

    private String accountName;

    private String externalId;

    private BigDecimal accountBalanceDerived;

    @Column(name = "is_blocked_by_bank")
    private boolean isBlockedByBank;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "savingsAccount", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SavingsAccountTransaction> transactions;

}
