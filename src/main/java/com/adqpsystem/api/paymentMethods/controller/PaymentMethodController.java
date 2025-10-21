package com.adqpsystem.api.paymentMethods.controller;

import com.adqpsystem.api.paymentMethods.dto.PaymentMethodCreateDTO;
import com.adqpsystem.api.paymentMethods.dto.PaymentMethodResponseDTO;
import com.adqpsystem.api.paymentMethods.dto.PaymentMethodUpdateDescriptionDTO;
import com.adqpsystem.api.paymentMethods.dto.PaymentMethodUpdateNameDTO;
import com.adqpsystem.api.paymentMethods.services.PaymentMethodCreateService;
import com.adqpsystem.api.paymentMethods.services.PaymentMethodQueryService;
import com.adqpsystem.api.paymentMethods.services.PaymentMethodStatusService;
import com.adqpsystem.api.paymentMethods.services.PaymentMethodsUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/payment-methods")
public class PaymentMethodController {

    private final PaymentMethodCreateService paymentMethodCreateService;
    private final PaymentMethodsUpdateService paymentMethodsUpdateService;
    private final PaymentMethodStatusService paymentMethodStatusService;
    private final PaymentMethodQueryService paymentMethodQueryService;

    @GetMapping
    public ResponseEntity<List<PaymentMethodResponseDTO>> findAllPaymentsActive() {
        return ResponseEntity.ok(paymentMethodQueryService.findAllActive());
    }

    @GetMapping("/deactivated")
    public ResponseEntity<List<PaymentMethodResponseDTO>> findAllPaymentsDeactivated() {
        return ResponseEntity.ok(paymentMethodQueryService.findAllDeactivated());
    }

    @PostMapping("/create")
    public ResponseEntity<PaymentMethodResponseDTO> create(@RequestBody PaymentMethodCreateDTO paymentMethodCreateDTO) {
        PaymentMethodResponseDTO newPayment = paymentMethodCreateService.create(paymentMethodCreateDTO);
        return ResponseEntity.created(URI.create("/api/v1/payment-methods" + newPayment.id())).body(newPayment);
    }

    @PatchMapping("{paymentId}/update-name")
    public ResponseEntity<Void> updateName(@PathVariable UUID paymentId, @RequestBody PaymentMethodUpdateNameDTO dto) {
        paymentMethodsUpdateService.updatePaymentMethodName(paymentId, dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{paymentId}/update-description")
    public ResponseEntity<Void> updateDescription(@PathVariable UUID paymentId, @RequestBody PaymentMethodUpdateDescriptionDTO dto) {
        paymentMethodsUpdateService.updatePaymentMethodDescription(paymentId, dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{paymentId}/activate")
    public ResponseEntity<Void> activatePayment(@PathVariable UUID paymentId) {
        paymentMethodStatusService.activate(paymentId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{paymentId}/deactivated")
    public ResponseEntity<Void> deactivatePayment(@PathVariable UUID paymentId) {
        paymentMethodStatusService.deactivate(paymentId);
        return ResponseEntity.noContent().build();
    }
}
