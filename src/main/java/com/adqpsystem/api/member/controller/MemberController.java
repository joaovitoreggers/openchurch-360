package com.adqpsystem.api.member.controller;

import com.adqpsystem.api.department.dto.DepartmentResponseDto;
import com.adqpsystem.api.member.services.MemberQueryService;
import com.adqpsystem.api.member.services.MemberStatusService;
import com.adqpsystem.api.member.services.MemberUpdateService;
import com.adqpsystem.api.member.services.MemberCreateService;
import com.adqpsystem.api.member.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberCreateService memberCreateService;
    private final MemberUpdateService memberUpdateService;
    private final MemberStatusService memberStatusService;
    private final MemberQueryService memberQueryService;

    @GetMapping()
    public ResponseEntity<List<MemberResponseDTO>> findAllActiveMembers() {
        return ResponseEntity.ok(memberQueryService.findAllActive());
    }

    @GetMapping("/inactive-members")
    public ResponseEntity<List<MemberResponseDTO>> findAllInactiveMembers() {
        return ResponseEntity.ok(memberQueryService.findAllDeactivate());
    }

    @GetMapping("/{memberId}/departments")
    public ResponseEntity<Set<DepartmentResponseDto>> findAllDepartmentsByMember(@PathVariable UUID memberId) {
        return ResponseEntity.ok(memberQueryService.findDepartmentsByMemberId(memberId));
    }

    @PostMapping("/create")
    public ResponseEntity<MemberResponseDTO> createMember(
            @RequestBody MemberCreateDTO memberDTO
    ) {
        MemberResponseDTO newMember = memberCreateService.create(memberDTO);
        return ResponseEntity.created(URI.create("/api/v1/users/" + newMember.id())).body(newMember);
    }

    @PatchMapping("/{memberId}/update-name")
    public ResponseEntity<Void> updateNameMember(
            @PathVariable UUID memberId,
            @RequestBody MemberUpdateNameDTO dto
            ){
        memberUpdateService.updateName(memberId, dto);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{memberId}/update-email")
    public ResponseEntity<Void> updateEmailMember(
            @PathVariable UUID memberId,
            @RequestBody MemberUpdateEmailDTO dto
    ) {
        memberUpdateService.updateEmail(memberId, dto);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{memberId}/update-address")
        public ResponseEntity<Void> updateAddressMember(
                @PathVariable UUID memberId,
                @RequestBody MemberUpdateAddressDTO dto
        ) {
        memberUpdateService.updateAddress(memberId, dto);
        return ResponseEntity.noContent().build();
        }

    @DeleteMapping("/{memberId}/delete")
        public ResponseEntity<Void> deleteMember(
                @PathVariable UUID memberId
        ){
            memberStatusService.deactivateMember(memberId);
            return ResponseEntity.noContent().build();
        }


}
