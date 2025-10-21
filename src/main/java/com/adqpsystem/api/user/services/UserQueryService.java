package com.adqpsystem.api.user.services;

import com.adqpsystem.api.common.entities.Email;
import com.adqpsystem.api.user.dto.UserResponseDTO;
import com.adqpsystem.api.user.mappers.UserMapper;
import com.adqpsystem.api.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserQueryService {
    private final UserRepository userRepository;

    public List<UserResponseDTO> findAllActiveUsers() {
        return userRepository.findByActiveTrue()
                .stream()
                .map(UserMapper::toDto)
                .toList();
    }

    public List<UserResponseDTO> findAllInactiveUsers() {
        return userRepository.findByActiveFalse()
                .stream()
                .map(UserMapper::toDto)
                .toList();
    }

    public  List<UserResponseDTO> findAllByEmail(String email) {
        Email queryEmail = Email.of(email);
        return userRepository.findByActiveTrueAndEmail(queryEmail)
                .stream()
                .map(UserMapper::toDto)
                .toList();
    }

    public List<UserResponseDTO> findAllByName(String name) {
        return userRepository.findByActiveTrueAndName(name)
                .stream()
                .map(UserMapper::toDto)
                .toList();
    }
}
