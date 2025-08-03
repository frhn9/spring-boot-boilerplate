package org.fd.project.modules.user.model.repository;

import org.fd.project.modules.user.model.entity.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Long> {
}
