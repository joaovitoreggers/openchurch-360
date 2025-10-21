package com.adqpsystem.api.paymentMethods.repositories;

import com.adqpsystem.api.paymentMethods.dto.PaymentMethodResponseDTO;
import com.adqpsystem.api.paymentMethods.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentMethodsRepository extends JpaRepository<PaymentMethod, UUID> {

    List<PaymentMethod> findAllByActiveIsTrue();
    List<PaymentMethod> findAllByActiveIsFalse();
}
