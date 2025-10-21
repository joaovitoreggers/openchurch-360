package com.adqpsystem.api.transaction.controller;

import com.adqpsystem.api.transaction.dto.TransactionCreateUpdateDTO;
import com.adqpsystem.api.transaction.dto.TransactionResponseDTO;
import com.adqpsystem.api.transaction.services.TransactionCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionCreateService  transactionCreateService;

    @PostMapping("/create")
    public ResponseEntity<TransactionResponseDTO> create(
            @RequestBody TransactionCreateUpdateDTO dto
    ) {
        return ResponseEntity.ok(transactionCreateService.create(dto));
    }
}
