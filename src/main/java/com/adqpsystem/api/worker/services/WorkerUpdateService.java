package com.adqpsystem.api.worker.services;


import com.adqpsystem.api.worker.dto.WorkerUpdateTitleDTO;
import com.adqpsystem.api.worker.entities.Worker;
import com.adqpsystem.api.worker.repository.WorkerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkerUpdateService {
    private final WorkerRepository workerRepository;

    public void workerUpdateTitle(UUID workerId, WorkerUpdateTitleDTO dto) {
        Worker worker = workerRepository.findById(workerId)
                .orElseThrow(() -> new EntityNotFoundException("Worker não encontrado"));

        worker.updateTitle(dto.title());
        workerRepository.save(worker);
    }
}
