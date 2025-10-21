package com.adqpsystem.api.department.dto;

import org.jetbrains.annotations.NotNull;

public record DepartmentUpdateDescriptionDto(
        @NotNull("O campo descrição não pode ser nulo") String description
){}
