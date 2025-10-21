package com.adqpsystem.api.department.services;


import com.adqpsystem.api.department.entities.Department;
import com.adqpsystem.api.department.repositories.DepartmentRepository;
import com.adqpsystem.api.member.entities.Member;
import com.adqpsystem.api.member.repositories.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor

public class DepartmentMemberService {
    private final MemberRepository memberRepository;
    private final DepartmentRepository departmentRepository;

    @Transactional
    public void addMemberToDepartment(UUID departmentId, UUID memberId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new EntityNotFoundException("Department not found:  " + departmentId));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found: " + memberId));

        if (department.getMembers().contains(member)) {
            return;
        }

        department.addMember(member);
        departmentRepository.save(department);
    }

    @Transactional
    public void removeMemberFromDepartment(UUID departmentId, UUID memberId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new EntityNotFoundException("Department not found: " + departmentId));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found: " + memberId));

        if (!department.getMembers().contains(member)) {
            return;
        }
        department.removeMember(member);
        departmentRepository.save(department);
    }
}
