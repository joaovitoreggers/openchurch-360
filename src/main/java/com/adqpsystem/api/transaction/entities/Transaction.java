package com.adqpsystem.api.transaction.entities;

import com.adqpsystem.api.member.entities.Member;
import com.adqpsystem.api.paymentMethods.entities.PaymentMethod;
import com.adqpsystem.api.transactionCategories.entities.TransactionCategory;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="transactions")
@Getter
public class Transaction {
    @Id
    @GeneratedValue()
    @Column(name = "id")
    private UUID transactionId;
    private BigDecimal amount;
    private String description;
    private boolean active;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "member_id", referencedColumnName = "id", nullable = false)
    private Member memberId;

    @OneToOne
    @JoinColumn(name = "transaction_category_id", referencedColumnName = "id", nullable = false)
    private TransactionCategory category;

    @ManyToOne
    @JoinColumn(name = "payment_method_id", referencedColumnName = "id", nullable = false)
    private PaymentMethod paymentMethod;

    protected Transaction() {}

    private Transaction( BigDecimal amount, String description, LocalDate date, Member memberId,
                         TransactionCategory category, PaymentMethod paymentMethod, boolean active
    ) {
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.memberId = memberId;
        this.category = category;
        this.paymentMethod = paymentMethod;
        this.active = active;
    }

    public void updateAmount(BigDecimal newAmount) {
        if (newAmount == null || newAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.amount = newAmount;
    }

    public void updateCategory(TransactionCategory newCategory) {
        if (newCategory == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }
        this.category = newCategory;
    }

    public void updatePaymentMethod(PaymentMethod newPaymentMethod) {
        if (newPaymentMethod == null) {
            throw new IllegalArgumentException("Payment method cannot be null");
        }
        this.paymentMethod = newPaymentMethod;
    }

    public void updateDate(LocalDate date) {
        if (date == null && this.date.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Date cannot be null and must be after now");
        }
        this.date = date;
    }

    public void updateDescription(String newDescription) {this.description = newDescription;}

    public void deactivate() {this.active = false;}

    public void activate() {this.active = true;}

    public void updateDetails(BigDecimal amount, String description,  LocalDate date,  TransactionCategory category, PaymentMethod paymentMethod
    ) {
        updateAmount(amount); updateDescription(description); updateDate(date); updateCategory(category); updatePaymentMethod(paymentMethod);
    }

    public static Transaction create(BigDecimal amount, String description, LocalDate date, Member member, TransactionCategory category, PaymentMethod paymentMethod
    ) {
        return new Transaction(amount, description, date, member, category, paymentMethod, true);
    }
}
