package com.adqpsystem.api.member.services;

import com.adqpsystem.api.member.entities.Member;
import com.adqpsystem.api.member.repositories.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberStatusService {

    private final MemberRepository memberRepository;


    public void deactivateMember(UUID memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("Member not found"));
        member.deactivate();
        memberRepository.save(member);
    }


    public void activateMember(UUID memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("Member not found")
        );
        member.activate();
        memberRepository.save(member);
    }
}
