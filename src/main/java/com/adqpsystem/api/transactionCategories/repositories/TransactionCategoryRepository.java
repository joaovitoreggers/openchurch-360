package com.adqpsystem.api.transactionCategories.repositories;

import com.adqpsystem.api.transactionCategories.entities.TransactionCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionCategoryRepository extends JpaRepository<TransactionCategory, UUID> {
    List<TransactionCategory> findByActiveIsTrue();
    List<TransactionCategory> findByActiveIsFalse();
    List<TransactionCategory> findAllByNameAndActiveIsTrueIgnoreCase(String name);
}
