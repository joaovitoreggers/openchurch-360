package com.adqpsystem.api.user.entities;

import com.adqpsystem.api.common.entities.AuditInfo;
import com.adqpsystem.api.common.entities.Email;
import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.UUID;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="users")

public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Embedded
    private Email email;

    @Embedded
    private Password password_hash;

    @Embedded
    private AuditInfo audit;

    private boolean active;

    private User(String name, Email email, Password password, AuditInfo audit) {
        this.name = name;
        this.email = email;
        this.password_hash = password;
        this.active = true;
        this.audit = audit;
    }

    public static @NotNull User create(String name, String emailAddress, String rawPassword, PasswordEncoder encoder, AuditInfo audit) {
        Email email = Email.of(emailAddress);
        Password password = Password.hash(rawPassword, encoder);
        return new User(name, email, password, audit);
    }

    public void updatePassword(String oldPassword, String newPassword, PasswordEncoder encoder) {
        if (!this.password_hash.matches(oldPassword, encoder)) {
            throw new IllegalArgumentException("Senha atual inválida");
    }
        this.password_hash = Password.hash(newPassword, encoder);
    }

    public void updateName(String newName) {
        this.name = newName;
    }

    public void updateEmail(String oldEmail, String newEmail) {
        if (!this.email.value().equals(oldEmail)) {
            throw new RuntimeException("Email antigo não confere");
        }
        this.email = Email.of(newEmail);
    }

    public void updateAudit(AuditInfo audit) {
        this.audit = audit;
    }

    public void deactivated() {
        this.active = false;
    }

    public void activated() {
        this.active = true;
    }



}
