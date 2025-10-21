package com.adqpsystem.api.transaction.dto;

import jakarta.validation.constraints.*;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record TransactionCreateUpdateDTO(
        @NotNull("Amount is required")
        @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
        @DecimalMax(value = "999999999.99", message = "Amount cannot exceed 999,999,999.99")
        @Digits(integer = 9, fraction = 2, message = "Amount format: maximum 9 integer digits and 2 decimal places")
        BigDecimal amount,

        @Size(min = 3, max = 255, message = "Description must be between 3 and 255 characters")
        String description,

        @NotNull("Date is required")
        @PastOrPresent()
        LocalDate date,

        @NotNull("Member id is required")
        UUID memberId,

        @NotNull("Transaction category ID is required")
        UUID categoryId,

        @NotNull("Payment method ID is required")
        UUID paymentMethodId

) {}