package com.adqpsystem.api.paymentMethods.dto;

import java.util.UUID;

public record PaymentMethodResponseDTO(UUID id, String name, String description) {}
