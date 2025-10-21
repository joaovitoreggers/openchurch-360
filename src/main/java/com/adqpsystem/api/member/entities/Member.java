package com.adqpsystem.api.member.entities;

import com.adqpsystem.api.department.entities.Department;
import com.adqpsystem.api.member.enums.Gender;
import com.adqpsystem.api.member.enums.MartialStatus;
import com.adqpsystem.api.common.entities.AuditInfo;
import com.adqpsystem.api.common.entities.Email;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;


import java.time.LocalDate;
import java.time.ZoneId;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name="member")
public class Member {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Embedded
    private Email email;

    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthday;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate baptismDate;

    @Embedded
    private PhoneNumber phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private MartialStatus martialStatus;

    private boolean active;

    @Embedded
    private AuditInfo audit;

    @ManyToMany(mappedBy = "members", fetch = FetchType.LAZY)
    private Set<Department> departments = new HashSet<>();

    private Member(LocalDate birthday, String name, Email email, String description, LocalDate baptismDate, AuditInfo audit, MartialStatus martialStatus, Address address, Gender gender, PhoneNumber phoneNumber) {
        this.birthday = birthday;
        this.name = name;
        this.email = email;
        this.description = description;
        this.baptismDate = baptismDate;
        this.audit = audit;
        this.martialStatus = martialStatus;
        this.address = address;
        this.active = true;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public static @NonNull Member create(
            String name,
            String email,
            String description,
            LocalDate birthday,
            LocalDate baptismDate,
            Gender gender,
            String street,
            String city,
            String state,
            String zipCode,
            String country,
            MartialStatus martialStatus,
            String phoneNumber,
            AuditInfo audit
    ) {

        Address address = Address.of(street, city, state, zipCode, country);
        PhoneNumber number = PhoneNumber.of(phoneNumber);
        Email newEmail = Email.of(email);

        return new Member(birthday, name, newEmail, description, baptismDate, audit, martialStatus, address, gender, number);
    }

    public void updateName(String newName) {
        if (newName == null || newName.isEmpty()) {
            throw new IllegalArgumentException("New name cannot be null or empty");
        }
        this.name = newName;
    }

    public void updateEmail(String oldEmail, String newEmail) {
        if (!this.email.value().equals(oldEmail)) {
            throw new RuntimeException("Email antigo não confere");
        }
        this.email = Email.of(newEmail);
    }

    public void updateAddress(String street, String city, String state, String zipCode, String country) {
        this.address = Address.of(street, city, state, zipCode, country);
    }

    public void addDepartment(Department department) {
        departments.add(department);
        department.getMembers().add(this);
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
        department.getMembers().remove(this);
    }

    public void deactivate() {
        this.active =  false;
    }

    public void activate() {
        this.active = true;
    }

    public void setId(@NotNull("Member id is required") UUID uuid) {

    }
}
