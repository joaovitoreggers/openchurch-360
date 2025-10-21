package com.adqpsystem.api.department.services;


import com.adqpsystem.api.department.dto.DepartmentResponseDto;
import com.adqpsystem.api.department.mappers.DepartmentMapper;
import com.adqpsystem.api.department.entities.Department;
import com.adqpsystem.api.department.repositories.DepartmentRepository;
import com.adqpsystem.api.member.dto.MemberResponseDTO;
import com.adqpsystem.api.member.mappers.MemberMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentQueryService {

    private final DepartmentRepository departmentRepository;

    public List<DepartmentResponseDto>  findAllActive() {
        return departmentRepository.findByActiveTrue()
                .stream()
                .map(DepartmentMapper::toDto)
                .toList();
    }

    public List<DepartmentResponseDto> findAllInactive() {
        return departmentRepository.findByActiveFalse()
                .stream()
                .map(DepartmentMapper::toDto)
                .toList();
    }

    public List<DepartmentResponseDto> findAllByName(String name) {
        return departmentRepository.findByActiveTrueAndNameLike(name)
                .stream()
                .map(DepartmentMapper::toDto)
                .toList();
    }

    public Set<MemberResponseDTO> getMembersByDepartment(UUID departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new EntityNotFoundException("Department not found: " + departmentId));

        return departmentRepository.findMembersByDepartment(department.getId())
                .stream()
                .map(MemberMapper::toDto)
                .collect(Collectors.toSet());
    }
}
