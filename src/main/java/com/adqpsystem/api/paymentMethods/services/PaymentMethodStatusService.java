package com.adqpsystem.api.paymentMethods.services;

import com.adqpsystem.api.paymentMethods.entities.PaymentMethod;
import com.adqpsystem.api.paymentMethods.repositories.PaymentMethodsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentMethodStatusService {

    private final PaymentMethodsRepository paymentMethodsRepository;

    public void deactivate(UUID id) {
        PaymentMethod paymentMethod = paymentMethodsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id " + id + " not found"));
        paymentMethod.deactivate();
        paymentMethodsRepository.save(paymentMethod);
    }

    public void activate(UUID id) {
        PaymentMethod paymentMethod = paymentMethodsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id " + id + " not found"));
        paymentMethod.activate();
        paymentMethodsRepository.save(paymentMethod);
    }
}
