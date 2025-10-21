package com.adqpsystem.api.member.dto;

import org.jetbrains.annotations.NotNull;

public record MemberUpdateAddressDTO(
        @NotNull("O campo rua não pode ser nulo") String street,
        @NotNull("O campo cidade não pode ser nulo") String city,
        @NotNull("O campo estado não pode ser nulo") String state,
        @NotNull("O campo código postal não pode ser nulo") String zipCode,
        @NotNull("O campo país não pode ser nulo") String country
        ) {}
