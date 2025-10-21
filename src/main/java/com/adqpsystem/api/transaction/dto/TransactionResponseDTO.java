package com.adqpsystem.api.transaction.dto;

import com.adqpsystem.api.member.entities.Member;
import com.adqpsystem.api.paymentMethods.entities.PaymentMethod;
import jdk.jfr.Category;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record TransactionResponseDTO(
        UUID transactionId,
        BigDecimal amount,
        String description,
        LocalDate date,
        MemberSummaryDTO member,
        TransactionCategorySummaryDTO category,
        PaymentMethodSummaryDTO paymentMethod,
        boolean active
){}
