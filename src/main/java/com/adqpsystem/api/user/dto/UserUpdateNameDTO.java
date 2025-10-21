package com.adqpsystem.api.user.dto;

import org.jetbrains.annotations.NotNull;

public record UserUpdateNameDTO(@NotNull("O valor de nome não pode ser nulo") String name) {
}
