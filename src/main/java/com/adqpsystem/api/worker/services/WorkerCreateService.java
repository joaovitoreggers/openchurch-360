package com.adqpsystem.api.worker.services;


import com.adqpsystem.api.member.entities.Member;
import com.adqpsystem.api.member.repositories.MemberRepository;
import com.adqpsystem.api.worker.dto.WorkerCreateDTO;
import com.adqpsystem.api.worker.dto.WorkerResponseDTO;
import com.adqpsystem.api.worker.mappers.WorkerMapper;
import com.adqpsystem.api.worker.entities.Worker;
import com.adqpsystem.api.worker.repository.WorkerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkerCreateService {
    private final WorkerRepository workerRepository;
    private final MemberRepository memberRepository;

    public WorkerResponseDTO create(WorkerCreateDTO dto) {
        Member member = memberRepository.findById(dto.member())
                .orElseThrow(() -> new EntityNotFoundException("Member not found"));
        Worker newWorker = WorkerMapper.toEntity(dto, member);

        return WorkerMapper.toResponseDTO(workerRepository.save(newWorker));
    }
}
