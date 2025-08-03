package org.fd.project.modules.user.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payment_detail")
@Getter
@Setter
public class PaymentDetail {

    @Id
    private Long id;

    private String accountNumber;

    private String routingCode;

    private String receiptNumber;

    private String bankNumber;

    @ManyToOne
    @JoinColumn(name = "payment_type_id", nullable = false)
    private PaymentType paymentType;

}
