package org.fd.project.modules.user.service.adapter.command;

import org.fd.project.modules.user.model.entity.PaymentDetail;

public interface PaymentDetailCommandAdapter {
    PaymentDetail save(PaymentDetail paymentDetail);
}
