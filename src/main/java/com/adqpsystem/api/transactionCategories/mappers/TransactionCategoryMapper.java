package com.adqpsystem.api.transactionCategories.mappers;

import com.adqpsystem.api.transactionCategories.dto.TransactionCategoryCreateDTO;
import com.adqpsystem.api.transactionCategories.dto.TransactionCategoryResponseDTO;
import com.adqpsystem.api.transactionCategories.entities.TransactionCategory;

public class TransactionCategoryMapper {

    public static TransactionCategoryResponseDTO toResponseDTO(TransactionCategory transactionCategory) {
        return new  TransactionCategoryResponseDTO(
                transactionCategory.getId(),
                transactionCategory.getName(),
                transactionCategory.getDescription(),
                transactionCategory.getTransactionType()
        );
    }

    public static TransactionCategory toEntity(TransactionCategoryCreateDTO dto) {
        return TransactionCategory.create(
                dto.name(),
                dto.description(),
                dto.transactionType()
        );
    }
}
