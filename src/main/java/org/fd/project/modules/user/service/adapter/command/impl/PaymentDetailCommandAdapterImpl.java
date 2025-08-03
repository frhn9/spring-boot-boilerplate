package org.fd.project.modules.user.service.adapter.command.impl;

import lombok.RequiredArgsConstructor;
import org.fd.project.modules.user.model.entity.PaymentDetail;
import org.fd.project.modules.user.model.repository.PaymentDetailRepository;
import org.fd.project.modules.user.service.adapter.command.PaymentDetailCommandAdapter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentDetailCommandAdapterImpl implements PaymentDetailCommandAdapter {

    private final PaymentDetailRepository paymentDetailRepository;

    @Override
    public PaymentDetail save(PaymentDetail paymentDetail) {
        return paymentDetailRepository.save(paymentDetail);
    }
}
