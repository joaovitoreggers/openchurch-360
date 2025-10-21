package com.adqpsystem.api.transactionCategories.entities;

import com.adqpsystem.api.transactionCategories.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Entity
@Table(name = "transaction_categories")
@NoArgsConstructor
@Getter
public class TransactionCategory {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String description;
    private boolean active;

    @Enumerated(EnumType.STRING)
    TransactionType transactionType;

    private TransactionCategory(String name, String description, TransactionType transactionType) {
        this.name = name;
        this.description = description;
        this.transactionType = transactionType;
        this.active = true;
    }

    public static TransactionCategory create(String name, String description, TransactionType transactionType) {
        return new TransactionCategory(name, description, transactionType);
    }

    public void updateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void updateDescription(String description) {
        this.description = description;
    }

    public void updateType(TransactionType transactionType) {
        if (transactionType == null) {
            throw new IllegalArgumentException("Transaction type cannot be null");
        }
        this.transactionType = transactionType;
    }

    public void activate(){
        this.active = true;
    }

    public void deactivate(){
        this.active = false;
    }

    public void setId(@NotNull("Transaction category ID is required") UUID uuid) {

    }
}
