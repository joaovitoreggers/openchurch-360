package com.adqpsystem.api.transactionCategories.controller;

import com.adqpsystem.api.transactionCategories.dto.*;
import com.adqpsystem.api.transactionCategories.services.TransactionCategoryCreateService;
import com.adqpsystem.api.transactionCategories.services.TransactionCategoryQueryService;
import com.adqpsystem.api.transactionCategories.services.TransactionCategoryStatusService;
import com.adqpsystem.api.transactionCategories.services.TransactionCategoryUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/transaction-categories")
public class TransactionCategoryController {

    private final TransactionCategoryCreateService transactionCategoryCreateService;
    private final TransactionCategoryUpdateService transactionCategoryUpdateService;
    private final TransactionCategoryQueryService transactionCategoryQueryService;
    private final TransactionCategoryStatusService transactionCategoryStatusService;

    @PostMapping("/create")
    public ResponseEntity<TransactionCategoryResponseDTO> createCategory(@RequestBody TransactionCategoryCreateDTO dto) {
        TransactionCategoryResponseDTO created = transactionCategoryCreateService.createTransactionCategory(dto);
        return ResponseEntity.created(URI.create("/api/v1/users/" + created.id())).body(created);
    }

    @PatchMapping("/{categoryId}/update-name/")
     public ResponseEntity<TransactionCategoryResponseDTO> updateCategoryName(
             @PathVariable UUID categoryId,
             @RequestBody @Validated TransactionCategoryUpdateNameDTO dto
    ) {
        transactionCategoryUpdateService.updateCategoryName(categoryId, dto);
        return ResponseEntity.noContent().build();
     }

     @PatchMapping("/{categoryId}/update-description/")
     public ResponseEntity<TransactionCategoryResponseDTO> updateCategoryDescription(
             @PathVariable UUID categoryId,
             @RequestBody @Validated TransactionCategoryUpdateDescriptionDTO dto
     ) {
        transactionCategoryUpdateService.updateCategoryDescription(categoryId, dto);
        return ResponseEntity.noContent().build();
     }

     @PatchMapping("/{categoryId}/update-type")
     public ResponseEntity<TransactionCategoryResponseDTO> updateCategoryType(
             @PathVariable UUID categoryId,
             TransactionCategoryUpdateTypeDTO dto
     ) {
        transactionCategoryUpdateService.updateCategoryType(categoryId, dto);
        return ResponseEntity.noContent().build();
     }






}
