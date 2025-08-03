package org.fd.project.modules.user.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "payment_type")
@Getter
@Setter
public class PaymentType {

    @Id
    private Long id;

    private String name;

    private boolean isCashPayment;

    private Long position;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "payment_type", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PaymentDetail> paymentDetails;

}
