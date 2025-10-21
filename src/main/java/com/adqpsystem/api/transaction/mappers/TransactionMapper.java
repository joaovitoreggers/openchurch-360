package com.adqpsystem.api.transaction.mappers;

import com.adqpsystem.api.member.entities.Member;
import com.adqpsystem.api.paymentMethods.entities.PaymentMethod;
import com.adqpsystem.api.transaction.entities.Transaction;
import com.adqpsystem.api.transaction.dto.*;
import com.adqpsystem.api.transactionCategories.entities.TransactionCategory;

public class TransactionMapper {
    public static Transaction toEntity(
            TransactionCreateUpdateDTO dto,
            Member member,
            TransactionCategory category,
            PaymentMethod paymentMethod
    ) {
        return Transaction.create(
                dto.amount(),
                dto.description(),
                dto.date(),
                member,
                category,
                paymentMethod
        );
    }

    public static TransactionResponseDTO toDTO(Transaction transaction) {
        return new TransactionResponseDTO(
                transaction.getTransactionId(),
                transaction.getAmount(),
                transaction.getDescription(),
                transaction.getDate(),
                MemberSummaryDTO.from(transaction.getMemberId()),
                TransactionCategorySummaryDTO.from(transaction.getCategory()),
                PaymentMethodSummaryDTO.from(transaction.getPaymentMethod()),
                transaction.isActive()
        );
    }
}
