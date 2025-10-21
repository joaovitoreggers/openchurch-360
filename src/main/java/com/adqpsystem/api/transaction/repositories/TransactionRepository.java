package com.adqpsystem.api.transaction.repositories;

import com.adqpsystem.api.member.entities.Member;
import com.adqpsystem.api.transaction.entities.Transaction;
import com.adqpsystem.api.transactionCategories.entities.TransactionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    boolean existsByCategory(TransactionCategory category);
    List<Transaction> findAllByActiveIsTrue();
    List<Transaction> findAllByActiveIsFalse();
    List<Transaction> findAllByMemberId_Id(UUID memberId);
    List<Transaction> findAllByPaymentMethodId_Id(UUID paymentMethodId);
    Transaction findByCategory(TransactionCategory category);

}
