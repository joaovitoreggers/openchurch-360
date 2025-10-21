package com.adqpsystem.api.paymentMethods.services;

import com.adqpsystem.api.paymentMethods.dto.PaymentMethodResponseDTO;
import com.adqpsystem.api.paymentMethods.mappers.PaymentMethodsMapper;
import com.adqpsystem.api.paymentMethods.repositories.PaymentMethodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentMethodQueryService {

    private final PaymentMethodsRepository paymentMethodsRepository;

    public List<PaymentMethodResponseDTO> findAllActive() {
        return paymentMethodsRepository.findAllByActiveIsTrue()
                .stream()
                .map(PaymentMethodsMapper::toDto)
                .toList();
    }

    public List<PaymentMethodResponseDTO> findAllDeactivated() {
        return paymentMethodsRepository.findAllByActiveIsTrue()
                .stream()
                .map(PaymentMethodsMapper::toDto)
                .toList();
    }
}
