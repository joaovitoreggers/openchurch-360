package com.adqpsystem.api.user.services;

import com.adqpsystem.api.common.entities.AuditInfo;
import com.adqpsystem.api.user.entities.User;
import com.adqpsystem.api.user.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserStatusService {
    private final UserRepository userRepository;

    public void deactivateUser(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("User not found"));
        user.deactivated();
        user.updateAudit(user.getAudit().recordUpdate());
        userRepository.save(user);
    }

    public void activateUser(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("User not found")
        );
        user.activated();
        user.updateAudit(AuditInfo.recordCreation());
        userRepository.save(user);
    }
}
