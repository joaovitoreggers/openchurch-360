package com.adqpsystem.api.worker.dto;

import com.adqpsystem.api.member.entities.Member;

import java.util.UUID;

public record WorkerResponseDTO(UUID id, String title, Member member) {}
