package com.adqpsystem.api.member.entities;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private  String country;

    private Address(String street, String city, String state, String zipCode, String country) {
        if (isNullOrBlank(street) || isNullOrBlank(city) || isNullOrBlank(state)
                || isNullOrBlank(zipCode) || isNullOrBlank(country)) {
            throw new IllegalArgumentException("Endereço inválido: todos os campos são obrigatórios.");
        }

        if (!zipCode.matches("\\d{5}-?\\d{3}")) {
            throw new IllegalArgumentException("CEP inválido.");
        }

        this.street = street.trim();
        this.city = city.trim();
        this.state = state.trim();
        this.zipCode = zipCode.trim();
        this.country = country.trim();
    }

    public static Address of(String street, String city, String state, String zipCode, String country) {
        return new Address(street, city, state, zipCode, country);
    }

    private static boolean isNullOrBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
