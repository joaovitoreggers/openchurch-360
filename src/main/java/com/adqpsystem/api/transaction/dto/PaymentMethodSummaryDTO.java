package com.adqpsystem.api.transaction.dto;

import com.adqpsystem.api.paymentMethods.entities.PaymentMethod;

import java.util.UUID;

public record PaymentMethodSummaryDTO(UUID id, String name) {
    public static PaymentMethodSummaryDTO from(PaymentMethod method) {
        if (method == null) return null;
        return new PaymentMethodSummaryDTO(method.getId(), method.getName());
    }
}
