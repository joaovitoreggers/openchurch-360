package com.adqpsystem.api.transaction.dto;
import com.adqpsystem.api.member.entities.Member;
import java.util.UUID;

public record MemberSummaryDTO(UUID id, String name) {
    public static MemberSummaryDTO from(Member member) {
        if (member == null) return null;
        return new MemberSummaryDTO(member.getId(), member.getName());
    }
}
