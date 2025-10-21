package com.adqpsystem.api.paymentMethods.mappers;

import com.adqpsystem.api.paymentMethods.dto.PaymentMethodCreateDTO;
import com.adqpsystem.api.paymentMethods.dto.PaymentMethodResponseDTO;
import com.adqpsystem.api.paymentMethods.entities.PaymentMethod;


public class PaymentMethodsMapper {
    public static PaymentMethod toEntity(PaymentMethodCreateDTO dto){
        return PaymentMethod.create(dto.name(), dto.description());
    }

    public static PaymentMethodResponseDTO toDto(PaymentMethod paymentMethod) {
        return new PaymentMethodResponseDTO(
                paymentMethod.getId(),
                paymentMethod.getName(),
                paymentMethod.getDescription()
        );
    }
}
