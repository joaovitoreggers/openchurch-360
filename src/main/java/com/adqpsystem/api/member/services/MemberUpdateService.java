package com.adqpsystem.api.member.services;

import com.adqpsystem.api.member.dto.MemberUpdateAddressDTO;
import com.adqpsystem.api.member.dto.MemberUpdateEmailDTO;
import com.adqpsystem.api.member.dto.MemberUpdateNameDTO;
import com.adqpsystem.api.member.entities.Member;
import com.adqpsystem.api.member.repositories.MemberRepository;
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

    public void updateAddress(UUID memberId, MemberUpdateAddressDTO dto) {
        Member member= memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found"));
        member.updateAddress(
                dto.street(),
                dto.city(),
                dto.state(),
                dto.zipCode(),
                dto.country()
        );
        memberRepository.save(member);
    }
}
