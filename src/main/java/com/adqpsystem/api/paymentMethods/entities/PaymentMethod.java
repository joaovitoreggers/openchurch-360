package com.adqpsystem.api.paymentMethods.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@Getter
@Entity
@Table(name = "payment_methods")
public class PaymentMethod {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String description;
    private boolean active;

    public PaymentMethod(){}
    public PaymentMethod(String name, String description) {
        this.name = name;
        this.description = description;
        this.active = true;
    }

    public static PaymentMethod create(String name, String description) {
        return new PaymentMethod(name, description);
    }

    public PaymentMethod updateName(String name) {
        this.name = name;
        return this;
    }

    public void updateDescription(String description) {
        this.description = description;
    }

    public void activate() {
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

    public void setId(@NotNull("Payment method ID is required") UUID uuid) {

    }
}
