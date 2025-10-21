package com.adqpsystem.api.department.services;


import com.adqpsystem.api.department.dto.DepartmentUpdateDescriptionDto;
import com.adqpsystem.api.department.dto.DepartmentUpdateNameDto;
import com.adqpsystem.api.department.entities.Department;
import com.adqpsystem.api.department.repositories.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DepartmentUpdateService {
    private final DepartmentRepository departmentRepository;

    public void updateName(DepartmentUpdateNameDto dto, UUID departmentId) {
        Department departmentUpdate = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));
        departmentUpdate.updateName(dto.name());
        departmentRepository.save(departmentUpdate);
    }

    public void updateDescription(DepartmentUpdateDescriptionDto dto, UUID departmentId) {
        Department departmentUpdate = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));
        departmentUpdate.updateDescription(dto.description());
        departmentRepository.save(departmentUpdate);
    }
}
