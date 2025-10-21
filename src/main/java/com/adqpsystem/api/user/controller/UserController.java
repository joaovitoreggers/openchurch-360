package com.adqpsystem.api.user.controller;

import com.adqpsystem.api.user.services.UserCreateService;
import com.adqpsystem.api.user.services.UserUpdateService;
import com.adqpsystem.api.user.services.UserQueryService;
import com.adqpsystem.api.user.services.UserStatusService;
import com.adqpsystem.api.user.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users/")
@RequiredArgsConstructor
public class UserController {

    private final UserCreateService createUserService;
    private final UserUpdateService userUpdateService;
    private final UserStatusService userStatusService;
    private final UserQueryService userQueryService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAllUsersActive() {
        return ResponseEntity.ok(userQueryService.findAllActiveUsers());
    }

    @GetMapping("/deactivated-users")
    public ResponseEntity<List<UserResponseDTO>> findAllUsersInactive() {
        return ResponseEntity.ok(userQueryService.findAllInactiveUsers());
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(
            @RequestBody UserCreateDTO userDTO
    ) {
        UserResponseDTO created = createUserService.create(userDTO);
        return ResponseEntity.created(URI.create("/api/v1/users/" + created.id())).body(created);
    }

    @PatchMapping("/{userId}/update-name")
    public ResponseEntity<Void> updateUserName(
            @PathVariable UUID userId,
            @RequestBody UserUpdateNameDTO dto
    ) {
        userUpdateService.updateName(userId, dto);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{userId}/update-email")
    public ResponseEntity<Void> updateUserEmail(
            @PathVariable UUID userId,
            @RequestBody UserUpdateEmailDTO dto
    ) {
        userUpdateService.updateEmail(userId, dto);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{userId}/update-password")
    public ResponseEntity<Void> updateUserPassword(
            @PathVariable UUID userId,
            @RequestBody UserUpdatePasswordDTO dto
    ) {
        userUpdateService.updatePassword(userId, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{userId}/delete")
    public ResponseEntity<Void> deleteUser(
            @PathVariable UUID userId
    ) {
        userStatusService.deactivateUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{userId}/reactive")
    public ResponseEntity<Void> reactiveUser(
            @PathVariable UUID userId
    ) {
        userStatusService.activateUser(userId);
        return ResponseEntity.noContent().build();
    }
}
