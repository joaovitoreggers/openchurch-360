package com.adqpsystem.api.department.controller;


import com.adqpsystem.api.department.dto.DepartmentCreateDto;
import com.adqpsystem.api.department.dto.DepartmentResponseDto;
import com.adqpsystem.api.department.dto.DepartmentUpdateDescriptionDto;
import com.adqpsystem.api.department.dto.DepartmentUpdateNameDto;
import com.adqpsystem.api.department.services.*;
import com.adqpsystem.api.member.dto.MemberResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/departments")
public class DepartmentController {

    private final DepartmentQueryService departmentQueryService;
    private final DepartmentStatusService departmentStatusService;
    private final DepartmentUpdateService departmentUpdateService;
    private final DepartmentCreateService departmentCreateService;
    private final DepartmentMemberService departmentMemberService;

    @GetMapping
    public ResponseEntity<List<DepartmentResponseDto>> findAllActiveDepartments() {
        return ResponseEntity.ok(departmentQueryService.findAllActive());
    }

    @GetMapping("/inactive-departments")
    public ResponseEntity<List<DepartmentResponseDto>> findAllInactiveDepartments() {
        return ResponseEntity.ok(departmentQueryService.findAllInactive());
    }

    @GetMapping("{departmentId}/members")
    public ResponseEntity<Set<MemberResponseDTO>> findMembersByDepartment(@PathVariable UUID departmentId) {
        return ResponseEntity.ok(departmentQueryService.getMembersByDepartment(departmentId));
    }

    @PostMapping("/create")
    public ResponseEntity<DepartmentResponseDto> createDepartment(
            @RequestBody DepartmentCreateDto dto
            ) {
        DepartmentResponseDto newDepartment = departmentCreateService.create(dto);
        return ResponseEntity.created(URI.create("/api/v1/users/" + newDepartment.id())).body(newDepartment);
    }

    @PatchMapping("{departmentId}/update-name")
    public ResponseEntity<Void> updateDepartmentName(
            @PathVariable UUID departmentId,
            @RequestBody DepartmentUpdateNameDto dto
    ) {
        departmentUpdateService.updateName(dto, departmentId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{departmentId}/update-description")
    public ResponseEntity<Void> updateDepartmentDescription(
            @PathVariable UUID departmentId,
            @RequestBody DepartmentUpdateDescriptionDto dto
    ) {
        departmentUpdateService.updateDescription(dto, departmentId);
        return  ResponseEntity.noContent().build();
    }

    @PostMapping("{deptId}/members/{memberId}")
    public ResponseEntity<Void> addMember(@PathVariable UUID deptId, @PathVariable UUID memberId) {
        departmentMemberService.addMemberToDepartment(deptId, memberId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{departmentId}/active")
    public ResponseEntity<Void> activate(
            @PathVariable UUID departmentId
    ) {
        departmentStatusService.active(departmentId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{departmentId}/deactivate")
    public ResponseEntity<Void> deactivate(
            @PathVariable UUID departmentId
    ) {
        departmentStatusService.inactive(departmentId);
        return ResponseEntity.noContent().build();
    }

}
