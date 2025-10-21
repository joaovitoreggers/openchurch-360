package com.adqpsystem.api.department.services;

import com.adqpsystem.api.department.dto.DepartmentCreateDto;
import com.adqpsystem.api.department.dto.DepartmentResponseDto;
import com.adqpsystem.api.department.mappers.DepartmentMapper;
import com.adqpsystem.api.department.entities.Department;
import com.adqpsystem.api.department.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentCreateService {

    private final DepartmentRepository departmentRepository;

    public DepartmentResponseDto create(DepartmentCreateDto dto){
        Department newDepartment = DepartmentMapper.toEntity(dto);
        departmentRepository.save(newDepartment);
        return DepartmentMapper.toDto(newDepartment);
    }
}
