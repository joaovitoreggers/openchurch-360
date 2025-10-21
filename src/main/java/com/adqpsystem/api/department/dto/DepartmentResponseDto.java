package com.adqpsystem.api.department.dto;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public record DepartmentResponseDto(
        @NotNull("O campo ID não pode ser nulo") UUID id,
        @NotNull("O campo nome não pode ser nulo") String name,
        @NotNull("O campo descrição não pode ser nulo") String description
){}
