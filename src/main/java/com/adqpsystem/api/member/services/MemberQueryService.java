package com.adqpsystem.api.member.services;

import com.adqpsystem.api.department.dto.DepartmentResponseDto;
import com.adqpsystem.api.department.mappers.DepartmentMapper;
import com.adqpsystem.api.member.dto.MemberResponseDTO;
import com.adqpsystem.api.member.mappers.MemberMapper;
import com.adqpsystem.api.member.entities.Member;
import com.adqpsystem.api.member.repositories.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberQueryService {

    private final MemberRepository memberRepository;

    public List<MemberResponseDTO> findAllActive() {
        return memberRepository.findByActiveTrue()
                .stream()
                .map(MemberMapper::toDto)
                .toList();
    }

    public List<MemberResponseDTO> findAllDeactivate() {
        return memberRepository.findByActiveFalse()
                .stream()
                .map(MemberMapper::toDto)
                .toList();
    }
/*
    public List<MemberResponseDTO> findAllByEmail(String email) {
        Email queryEmail = Email.of(email);
        return memberRepository.findByActiveTrueAndEmail(queryEmail)
                .stream()
                .map(mappers::toDto)
                .toList();
    }

    public List<MemberResponseDTO> findAllByName(String name) {
        return memberRepository.findByActiveTrueAndNameLike(name)
                .stream()
                .map(mappers::toDto)
                .toList();
    }
*/
    public Set<DepartmentResponseDto> findDepartmentsByMemberId(UUID memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found: "  + memberId));

        return memberRepository.findDepartmentsByMember(member.getId())
                .stream()
                .map(DepartmentMapper::toDto)
                .collect(Collectors.toSet());
    }
}
