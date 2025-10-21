package com.adqpsystem.api.worker.services;

import com.adqpsystem.api.worker.entities.Worker;
import com.adqpsystem.api.worker.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkerStatusService {

    private final WorkerRepository workerRepository;

    public void deactivateWorker(UUID workerId) {
        Worker worker = workerRepository.findById(workerId).orElseThrow(
                () -> new IllegalArgumentException("worker not found")
        );
        worker.deactivate();
        workerRepository.save(worker);
    }

    public void activateWorker(UUID workerId) {
        Worker worker = workerRepository.findById(workerId).orElseThrow(
                () -> new IllegalArgumentException("worker not found")
        );
        worker.activate();
        workerRepository.save(worker);
    }
}
