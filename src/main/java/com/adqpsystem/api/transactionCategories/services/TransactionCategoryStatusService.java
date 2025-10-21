package com.adqpsystem.api.transactionCategories.services;

import com.adqpsystem.api.transaction.repositories.TransactionRepository;
import com.adqpsystem.api.transactionCategories.entities.TransactionCategory;
import com.adqpsystem.api.transactionCategories.repositories.TransactionCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionCategoryStatusService {
    private final TransactionCategoryRepository categoryRepository;
    private final TransactionRepository transactionRepository;

    public void deactivateCategory(UUID categoryId) {
        TransactionCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category Not Found"));

        boolean hasTransaction = transactionRepository.existsByCategory(category);

        if (hasTransaction) {
            throw new IllegalArgumentException("Não é possível deletar uma categoria que tem transações relacionadas");
        }
        category.deactivate();
        categoryRepository.save(category);
    }

    public void activateCategory(UUID categoryId) {
        TransactionCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category Not Found"));

        category.activate();
        categoryRepository.save(category);
    }

}
