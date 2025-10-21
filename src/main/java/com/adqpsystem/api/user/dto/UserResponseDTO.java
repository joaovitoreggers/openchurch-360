package com.adqpsystem.api.user.dto;

import com.adqpsystem.api.user.entities.User;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponseDTO(
        UUID id,
        String name,
        String email,
        boolean active,
        LocalDateTime createdAt
) {
    public static UserResponseDTO from(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail().toString(),
                user.isActive(),
                user.getAudit().getCreatedAt()
        );
    }
}