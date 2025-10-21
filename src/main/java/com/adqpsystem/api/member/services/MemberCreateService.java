package com.adqpsystem.api.member.services;

import com.adqpsystem.api.member.dto.MemberResponseDTO;
import com.adqpsystem.api.member.mappers.MemberMapper;
import com.adqpsystem.api.member.entities.Member;
import com.adqpsystem.api.member.dto.MemberCreateDTO;
import com.adqpsystem.api.common.entities.Email;
import com.adqpsystem.api.member.repositories.MemberRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCreateService {


    private final MemberRepository memberRepository;

    public MemberResponseDTO create(MemberCreateDTO dto) {
        if (memberRepository.existsByEmail(Email.of(dto.email()))) {
            throw new EntityExistsException("Email já cadastrado!");
        }

        Member newMember = MemberMapper.toEntity(dto);
        memberRepository.save(newMember);
        return MemberMapper.toDto(newMember);
    }
}