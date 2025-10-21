package com.adqpsystem.api.transactionCategories.services;

import com.adqpsystem.api.transactionCategories.dto.TransactionCategoryCreateDTO;
import com.adqpsystem.api.transactionCategories.dto.TransactionCategoryResponseDTO;
import com.adqpsystem.api.transactionCategories.mappers.TransactionCategoryMapper;
import com.adqpsystem.api.transactionCategories.entities.TransactionCategory;
import com.adqpsystem.api.transactionCategories.repositories.TransactionCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionCategoryCreateService {

    private final TransactionCategoryRepository transactionCategoryRepository;

    public TransactionCategoryResponseDTO createTransactionCategory(TransactionCategoryCreateDTO dto) {
        TransactionCategory newCategory = TransactionCategoryMapper.toEntity(dto);
        transactionCategoryRepository.save(newCategory);
        return TransactionCategoryMapper.toResponseDTO(newCategory);
    }
}

