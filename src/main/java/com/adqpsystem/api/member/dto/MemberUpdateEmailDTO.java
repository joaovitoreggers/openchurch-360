package com.adqpsystem.api.member.dto;

import org.jetbrains.annotations.NotNull;

public record MemberUpdateEmailDTO(
        @NotNull("O email antigo não pode ser um campo nulo!") String oldEmail,
        @NotNull("O novo email não pode ser um campo nulo!") String newEmail
) {}
