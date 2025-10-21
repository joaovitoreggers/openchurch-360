package com.adqpsystem.api.user.services;

import com.adqpsystem.api.user.dto.UserUpdateEmailDTO;
import com.adqpsystem.api.user.dto.UserUpdateNameDTO;
import com.adqpsystem.api.user.dto.UserUpdatePasswordDTO;
import com.adqpsystem.api.common.entities.AuditInfo;
import com.adqpsystem.api.user.entities.User;
import com.adqpsystem.api.user.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserUpdateService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void updateName(UUID userId, UserUpdateNameDTO dto) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("User not found")
        );
        user.updateName(dto.name());
        user.updateAudit(AuditInfo.recordCreation());
        userRepository.save(user);
    }

    public void updateEmail(UUID userId, UserUpdateEmailDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        user.updateEmail(dto.oldEmail(), dto.newEmail());
        user.updateAudit(user.getAudit().recordUpdate());
        userRepository.save(user);
    }

    public void updatePassword(UUID userId, UserUpdatePasswordDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.updatePassword(dto.oldPassword(), dto.newPassword(), passwordEncoder);
        user.updateAudit(user.getAudit().recordUpdate());
        userRepository.save(user);
    }




}
