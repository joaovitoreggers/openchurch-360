package com.adqpsystem.api.worker.controller;


import com.adqpsystem.api.worker.dto.WorkerCreateDTO;
import com.adqpsystem.api.worker.dto.WorkerResponseDTO;
import com.adqpsystem.api.worker.dto.WorkerUpdateTitleDTO;
import com.adqpsystem.api.worker.services.WorkerCreateService;
import com.adqpsystem.api.worker.services.WorkerUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/workers/")
public class WorkerController {

    private final WorkerCreateService workerCreateService;
    private final WorkerUpdateService workerUpdateService;

    @PostMapping("/create")
    public ResponseEntity<WorkerResponseDTO> createWorker(@RequestBody WorkerCreateDTO dto) {
        WorkerResponseDTO newWorker = workerCreateService.create(dto);
        return ResponseEntity.created(URI.create("/api/v1/workers/" + newWorker.id())).body(newWorker);
    }

    @PatchMapping("/{memberId}/update-title/")
    public ResponseEntity<Void> updateWorkerTitle(
            @PathVariable UUID memberId,
            @RequestBody WorkerUpdateTitleDTO dto
    ) {
        workerUpdateService.workerUpdateTitle(memberId, dto);
        return ResponseEntity.noContent().build();
    }
}
