package com.adqpsystem.api.user.dto;

import com.adqpsystem.api.common.entities.AuditInfo;
import org.springframework.security.crypto.password.PasswordEncoder;


public record UserCreateDTO(String name, String email, String password, PasswordEncoder passwordEncoder, AuditInfo auditInfo) {}
