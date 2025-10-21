package com.adqpsystem.api.worker.services;

import com.adqpsystem.api.worker.dto.WorkerResponseDTO;
import com.adqpsystem.api.worker.mappers.WorkerMapper;
import com.adqpsystem.api.worker.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerQueryService {

    private final WorkerRepository workerRepository;

    public List<WorkerResponseDTO> findAllByActiveTrue(String workerId) {
        return workerRepository.findAllByActiveIsTrue()
                .stream()
                .map(WorkerMapper::toResponseDTO)
                .toList();
    }

    public List<WorkerResponseDTO> findAllByActiveFalse(String workerId) {
        return workerRepository.findAllByActiveIsFalse()
                .stream()
                .map(WorkerMapper::toResponseDTO)
                .toList();
    }

    public List<WorkerResponseDTO> findByTitle(String title) {
        return workerRepository.findAllByTitle(title)
                .stream()
                .map(WorkerMapper::toResponseDTO)
                .toList();
    }

}
