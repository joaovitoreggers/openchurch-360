package com.adqpsystem.api.transactionCategories.services;

import com.adqpsystem.api.transactionCategories.dto.TransactionCategoryUpdateDescriptionDTO;
import com.adqpsystem.api.transactionCategories.dto.TransactionCategoryUpdateNameDTO;
import com.adqpsystem.api.transactionCategories.dto.TransactionCategoryUpdateTypeDTO;
import com.adqpsystem.api.transactionCategories.entities.TransactionCategory;
import com.adqpsystem.api.transactionCategories.repositories.TransactionCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionCategoryUpdateService {

    private final TransactionCategoryRepository categoryRepository;

    public void updateCategoryName(UUID categoryId, TransactionCategoryUpdateNameDTO dto) {
        TransactionCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found: " + categoryId));

        category.updateName(dto.name());
        categoryRepository.save(category);
    }

    public void updateCategoryDescription(UUID categoryId, TransactionCategoryUpdateDescriptionDTO dto) {
        TransactionCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found: " + categoryId));

        category.updateDescription(dto.description());
        categoryRepository.save(category);
    }

    public void updateCategoryType(UUID categoryId, TransactionCategoryUpdateTypeDTO dto) {
        TransactionCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found: " + categoryId));

        category.updateType(dto.transactionType());
        categoryRepository.save(category);
    }
}
