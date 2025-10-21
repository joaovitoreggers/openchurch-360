package com.adqpsystem.api.transactionCategories.dto;


import com.adqpsystem.api.transactionCategories.enums.TransactionType;

public record TransactionCategoryCreateDTO(String name, String description, TransactionType transactionType) {}
