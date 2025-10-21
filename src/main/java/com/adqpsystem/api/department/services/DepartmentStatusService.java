package com.adqpsystem.api.department.services;

import com.adqpsystem.api.department.entities.Department;
import com.adqpsystem.api.department.repositories.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DepartmentStatusService {
    private final DepartmentRepository departmentRepository;

    public void active(UUID departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));
        department.active();
        departmentRepository.save(department);
    }

    public void inactive(UUID departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));
        department.inactive();
        departmentRepository.save(department);
    }
}
