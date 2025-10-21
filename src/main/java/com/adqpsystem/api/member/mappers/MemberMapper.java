package com.adqpsystem.api.member.mappers;
import com.adqpsystem.api.member.dto.MemberCreateDTO;
import com.adqpsystem.api.member.dto.MemberResponseDTO;
import com.adqpsystem.api.member.entities.Member;
import com.adqpsystem.api.common.entities.AuditInfo;

import java.time.LocalDate;
import java.time.ZoneId;

public class MemberMapper {

    public static Member toEntity(MemberCreateDTO dto) {
        return Member.create(
                dto.name(),
                dto.email(),
                dto.description(),
                dto.birthday(),
                dto.baptismDate(),
                dto.gender(),
                dto.street(),
                dto.city(),
                dto.state(),
                dto.zipCode(),
                dto.coutry(),
                dto.martialStatus(),
                dto.phoneNumber(),
                AuditInfo.recordCreation()
        );
    }

    public static MemberResponseDTO toDto(Member member) {
        LocalDate birthday = member.getBirthday();
        LocalDate baptismDate = member.getBaptismDate();
        return new MemberResponseDTO(
                member.getId(),
                member.getName(),
                member.getEmail().toString(),
                member.getDescription(),
                birthday,
                baptismDate,
                member.getGender(),
                member.getAddress().getStreet(),
                member.getAddress().getCity(),
                member.getAddress().getState(),
                member.getAddress().getZipCode(),
                member.getAddress().getCountry(),
                member.isActive(),
                member.getMartialStatus(),
                member.getPhoneNumber().getNumber()
        );
    }
}
