package com.adqpsystem.api.department.dto;

import org.jetbrains.annotations.NotNull;

public record DepartmentUpdateNameDto(
        @NotNull("O campo nome não pode ser nulo") String name
){}
