package com.adqpsystem.api.department.dto;

import org.jetbrains.annotations.NotNull;

public record DepartmentCreateDto(
        @NotNull("O campo nome não pode ser nulo") String name,
        @NotNull("O campo Description não pode ser nulo") String description
){}
