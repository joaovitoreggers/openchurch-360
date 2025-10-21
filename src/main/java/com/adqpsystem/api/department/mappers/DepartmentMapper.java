package com.adqpsystem.api.department.mappers;

import com.adqpsystem.api.department.dto.DepartmentCreateDto;
import com.adqpsystem.api.department.dto.DepartmentResponseDto;
import com.adqpsystem.api.department.entities.Department;

public class DepartmentMapper {
    public static DepartmentResponseDto toDto(Department department) {
        return new DepartmentResponseDto(
                department.getId(),
                department.getName(),
                department.getDescription()
        );
    }

    public static Department toEntity(DepartmentCreateDto dto) {
        return Department.create(
                dto.name(),
                dto.description()
        );
    }
}
