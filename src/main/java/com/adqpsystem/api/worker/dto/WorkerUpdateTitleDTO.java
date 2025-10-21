package com.adqpsystem.api.worker.dto;

import org.jetbrains.annotations.NotNull;

public record WorkerUpdateTitleDTO(
        @NotNull("O campo title não pode ser nulo") String title
) {}
