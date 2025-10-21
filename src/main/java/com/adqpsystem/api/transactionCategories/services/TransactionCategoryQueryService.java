package com.adqpsystem.api.transactionCategories.services;

import com.adqpsystem.api.transactionCategories.dto.TransactionCategoryResponseDTO;
import com.adqpsystem.api.transactionCategories.mappers.TransactionCategoryMapper;
import com.adqpsystem.api.transactionCategories.repositories.TransactionCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionCategoryQueryService {
    private final TransactionCategoryRepository categoryRepository;

    public List<TransactionCategoryResponseDTO> findAllActive() {
        return categoryRepository.findByActiveIsTrue()
                .stream()
                .map(TransactionCategoryMapper::toResponseDTO)
                .toList();
    }

    public List<TransactionCategoryResponseDTO> findAllInactive() {
        return categoryRepository.findByActiveIsFalse()
                .stream()
                .map(TransactionCategoryMapper::toResponseDTO)
                .toList();
    }

    public List<TransactionCategoryResponseDTO> findByName(String name) {
        return categoryRepository.findAllByNameAndActiveIsTrueIgnoreCase(name)
                .stream()
                .map(TransactionCategoryMapper::toResponseDTO)
                .toList();
    }

}
