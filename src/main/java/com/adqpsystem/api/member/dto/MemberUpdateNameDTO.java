package com.adqpsystem.api.member.dto;

import org.jetbrains.annotations.NotNull;

public record MemberUpdateNameDTO(
        @NotNull("O campo nome não pode ser nulo") String name
) {}
