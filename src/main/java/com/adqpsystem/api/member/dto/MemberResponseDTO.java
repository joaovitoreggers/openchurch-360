package com.adqpsystem.api.member.dto;

import com.adqpsystem.api.member.enums.Gender;
import com.adqpsystem.api.member.enums.MartialStatus;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.UUID;

public record MemberResponseDTO(
        @NonNull UUID id,
        @NonNull String name,
        @NonNull String email,
        @NonNull String description,
        @NonNull LocalDate birthday,
        @NonNull LocalDate baptismDate,
        @NonNull Gender gender,
        @NonNull String street,
        @NonNull String city,
        @NonNull String state,
        @NonNull String zipCode,
        @NonNull String country,
        boolean active,
        @NonNull MartialStatus martialStatus,
        @NonNull String phoneNumber
) {}
