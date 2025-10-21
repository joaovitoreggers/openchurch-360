package com.adqpsystem.api.department.repositories;

import com.adqpsystem.api.department.entities.Department;
import com.adqpsystem.api.member.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {
    List<Department> findByActiveTrueAndNameLike(String name);

    List<Department> findByActiveTrue();

    List<Department> findByActiveFalse();

    @Query("SELECT d.members FROM Department d WHERE d.id = :deptId")
    Set<Member> findMembersByDepartment(@Param("deptId") UUID deptId);
}