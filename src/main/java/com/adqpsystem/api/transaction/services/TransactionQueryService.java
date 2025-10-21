package com.adqpsystem.api.transaction.services;

import com.adqpsystem.api.transaction.dto.TransactionResponseDTO;
import com.adqpsystem.api.transaction.mappers.TransactionMapper;
import com.adqpsystem.api.transaction.repositories.TransactionRepository;
import com.adqpsystem.api.transactionCategories.entities.TransactionCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionQueryService {

    private final TransactionRepository transactionRepository;

    public List<TransactionResponseDTO> findActive() {
        return transactionRepository.findAllByActiveIsTrue()
                .stream()
                .map(TransactionMapper::toDTO)
                .toList();
    }

    public List<TransactionResponseDTO> findInactive() {
        return transactionRepository.findAllByActiveIsFalse()
                .stream()
                .map(TransactionMapper::toDTO)
                .toList();
    }

    public List<TransactionResponseDTO> findByPaymentMethodId(UUID paymentMethodId) {
        return transactionRepository.findAllByPaymentMethodId_Id(paymentMethodId)
                .stream()
                .map(TransactionMapper::toDTO)
                .toList();
    }

    public List<TransactionResponseDTO> findByMemberId(UUID memberId) {
        return transactionRepository.findAllByMemberId_Id(memberId)
                .stream()
                .map(TransactionMapper::toDTO)
                .toList();
    }

    public TransactionResponseDTO findByCategory(TransactionCategory category) {
        return TransactionMapper.toDTO(transactionRepository.findByCategory(category));
    }

}
