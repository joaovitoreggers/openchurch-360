package com.adqpsystem.api.worker.mappers;


import com.adqpsystem.api.member.entities.Member;
import com.adqpsystem.api.worker.dto.WorkerCreateDTO;
import com.adqpsystem.api.worker.dto.WorkerResponseDTO;
import com.adqpsystem.api.worker.entities.Worker;

public class WorkerMapper {
    public static Worker toEntity(WorkerCreateDTO dto, Member member) {
        return Worker.create(
                dto.title(),
                member
        );
    }

    public static WorkerResponseDTO toResponseDTO(Worker worker) {
        return new WorkerResponseDTO(
                worker.getId(),
                worker.getTitle(),
                worker.getMember()
        );
    }
}
