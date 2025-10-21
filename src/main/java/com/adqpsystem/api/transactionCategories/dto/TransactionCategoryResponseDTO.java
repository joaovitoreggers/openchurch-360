package com.adqpsystem.api.transactionCategories.dto;

import com.adqpsystem.api.transactionCategories.enums.TransactionType;

import java.util.UUID;

public record TransactionCategoryResponseDTO(UUID id, String name, String description, TransactionType transactionType) {
}
