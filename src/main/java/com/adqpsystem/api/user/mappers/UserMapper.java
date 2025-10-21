package com.adqpsystem.api.user.mappers;

import com.adqpsystem.api.user.dto.UserCreateDTO;
import com.adqpsystem.api.user.dto.UserResponseDTO;
import com.adqpsystem.api.common.entities.AuditInfo;
import com.adqpsystem.api.user.entities.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapper {
    public static UserResponseDTO toDto(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail().toString(),
                user.isActive(),
                user.getAudit().getCreatedAt()
        );
    }

    public static User toEntity(UserCreateDTO dto, PasswordEncoder passwordEncoder) {
        AuditInfo audit = AuditInfo.recordCreation();
        return User.create(
                dto.name(),
                dto.email(),
                dto.password(),
                passwordEncoder,
                audit
        );
    }
}
