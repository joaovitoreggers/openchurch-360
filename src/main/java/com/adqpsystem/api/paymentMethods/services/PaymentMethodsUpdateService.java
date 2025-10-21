package com.adqpsystem.api.paymentMethods.services;

import com.adqpsystem.api.paymentMethods.dto.PaymentMethodUpdateDescriptionDTO;
import com.adqpsystem.api.paymentMethods.dto.PaymentMethodUpdateNameDTO;
import com.adqpsystem.api.paymentMethods.entities.PaymentMethod;
import com.adqpsystem.api.paymentMethods.repositories.PaymentMethodsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentMethodsUpdateService {

    private final PaymentMethodsRepository paymentMethodsRepository;

    public void updatePaymentMethodName(UUID id, PaymentMethodUpdateNameDTO dto) {
        PaymentMethod paymentMethod = paymentMethodsRepository.findById(id).
                orElseThrow(()-> new EntityNotFoundException("Entity not found"));

        paymentMethod.updateName(dto.name());
        paymentMethodsRepository.save(paymentMethod);
    }

    public void updatePaymentMethodDescription(UUID id, PaymentMethodUpdateDescriptionDTO dto) {
        PaymentMethod paymentMethod = paymentMethodsRepository.findById(id).
                orElseThrow(()-> new EntityNotFoundException("Entity not found"));

        paymentMethod.updateDescription(dto.description());
        paymentMethodsRepository.save(paymentMethod);
    }
}
