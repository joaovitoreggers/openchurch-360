package com.adqpsystem.api.transaction.dto;

import com.adqpsystem.api.transactionCategories.entities.TransactionCategory;

import java.util.UUID;

public record TransactionCategorySummaryDTO(UUID id, String name) {
    public static TransactionCategorySummaryDTO from(TransactionCategory category) {
        if (category == null) return null;
        return new TransactionCategorySummaryDTO(category.getId(), category.getName());
    }
}
