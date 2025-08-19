package com.adqpsystem.api.application.services.member;

import com.adqpsystem.api.api.dto.member.MemberUpdateEmailDTO;
import com.adqpsystem.api.api.dto.member.MemberUpdateNameDTO;
import com.adqpsystem.api.domain.entities.member.Member;
import com.adqpsystem.api.infraestructure.repositories.member.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberUpdateService {

    private final MemberRepository memberRepository;

    public void updateEmail(UUID memberId, MemberUpdateEmailDTO dto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found"));
        member.updateEmail(dto.oldEmail(), dto.newEmail());
        memberRepository.save(member);
    }

    public void updateName(UUID memberId, MemberUpdateNameDTO dto) {
        Member member= memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found"));
        member.updateName(dto.name());
        memberRepository.save(member);
    }
}
