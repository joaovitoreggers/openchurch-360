package com.adqpsystem.api.department.dto;

import java.util.UUID;

public record DepartmentMemberDTO(
        UUID memberId,
        UUID departmentId
){}
