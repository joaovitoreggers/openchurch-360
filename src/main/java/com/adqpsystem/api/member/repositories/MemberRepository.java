package com.adqpsystem.api.member.repositories;

import com.adqpsystem.api.department.entities.Department;
import com.adqpsystem.api.member.entities.Member;
import com.adqpsystem.api.common.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> {
    boolean existsByEmail(Email email);
    List<Member> findByActiveTrue();
    List<Member> findByActiveFalse();

    /*
    List<Member> findByActiveTrueAndEmail( Email email);
    List<Member> findByActiveTrueAndNameLike(String name);
*/
    @Query("SELECT d FROM Department d JOIN d.members m WHERE m.id = :memberId")
    Set<Department> findDepartmentsByMember(@Param("memberId") UUID memberId);

}
