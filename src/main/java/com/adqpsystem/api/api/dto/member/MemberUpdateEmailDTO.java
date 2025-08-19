package com.adqpsystem.api.api.dto.member;

import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

public record MemberUpdateEmailDTO(
        @NotNull("O email antigo não pode ser um campo nulo!") String oldEmail,
        @NotNull("O novo email não pode ser um campo nulo!") String newEmail
) {}
