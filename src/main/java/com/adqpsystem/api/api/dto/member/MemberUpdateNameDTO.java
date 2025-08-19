package com.adqpsystem.api.api.dto.member;

import org.jetbrains.annotations.NotNull;

public record MemberUpdateNameDTO(
        @NotNull("O campo nome não pode ser nulo") String name
) {}
