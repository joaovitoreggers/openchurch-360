package com.adqpsystem.api.user.services;

import com.adqpsystem.api.user.dto.UserCreateDTO;
import com.adqpsystem.api.user.dto.UserResponseDTO;
import com.adqpsystem.api.user.mappers.UserMapper;
import com.adqpsystem.api.common.entities.Email;
import com.adqpsystem.api.user.entities.User;
import com.adqpsystem.api.user.repositories.UserRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCreateService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDTO create(UserCreateDTO dto) {
        if (userRepository.existsByEmail(Email.of(dto.email()))) {
            throw new EntityExistsException("Email já cadastrado!");
        }

        User newUser = UserMapper.toEntity(dto, passwordEncoder);

        userRepository.save(newUser);
        return UserMapper.toDto(newUser);
    }
}
