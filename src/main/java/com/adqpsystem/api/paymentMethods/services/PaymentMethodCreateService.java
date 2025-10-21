package com.adqpsystem.api.paymentMethods.services;

import com.adqpsystem.api.paymentMethods.dto.PaymentMethodCreateDTO;
import com.adqpsystem.api.paymentMethods.dto.PaymentMethodResponseDTO;
import com.adqpsystem.api.paymentMethods.entities.PaymentMethod;
import com.adqpsystem.api.paymentMethods.mappers.PaymentMethodsMapper;
import com.adqpsystem.api.paymentMethods.repositories.PaymentMethodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentMethodCreateService {
    private final PaymentMethodsRepository paymentMethodsRepository;

    public PaymentMethodResponseDTO create(PaymentMethodCreateDTO paymentMethodCreateDTO) {
        PaymentMethod paymentMethod = PaymentMethodsMapper.toEntity(paymentMethodCreateDTO);
        paymentMethodsRepository.save(paymentMethod);
        return PaymentMethodsMapper.toDto(paymentMethod);
    }
}
