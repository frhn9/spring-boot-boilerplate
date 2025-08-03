package org.fd.project.modules.user.model.repository;

import org.fd.project.modules.user.model.entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {

    Optional<PaymentType> findByName(String name);

}
