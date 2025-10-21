package com.adqpsystem.api.transaction.services;

import com.adqpsystem.api.member.entities.Member;
import com.adqpsystem.api.member.repositories.MemberRepository;
import com.adqpsystem.api.paymentMethods.entities.PaymentMethod;
import com.adqpsystem.api.paymentMethods.repositories.PaymentMethodsRepository;
import com.adqpsystem.api.transaction.dto.TransactionCreateUpdateDTO;
import com.adqpsystem.api.transaction.dto.TransactionResponseDTO;
import com.adqpsystem.api.transaction.entities.Transaction;
import com.adqpsystem.api.transaction.mappers.TransactionMapper;
import com.adqpsystem.api.transaction.repositories.TransactionRepository;
import com.adqpsystem.api.transactionCategories.entities.TransactionCategory;
import com.adqpsystem.api.transactionCategories.repositories.TransactionCategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionCreateService {
    private final TransactionRepository transactionRepository;
    private final TransactionCategoryRepository transactionCategoryRepository;
    private final PaymentMethodsRepository paymentMethodsRepository;
    private final MemberRepository memberRepository;

    public TransactionResponseDTO create(TransactionCreateUpdateDTO dto) {
        Member member = memberRepository.findById(dto.memberId())
                .orElseThrow(() -> new EntityNotFoundException("Member not found"));
        TransactionCategory category = transactionCategoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        PaymentMethod paymentMethod = paymentMethodsRepository.findById(dto.paymentMethodId())
                .orElseThrow(() -> new EntityNotFoundException("Payment method not found"));

        Transaction newTransaction = TransactionMapper.toEntity(dto, member, category, paymentMethod);
        transactionRepository.save(newTransaction);
        return TransactionMapper.toDTO(newTransaction);
    }

}
