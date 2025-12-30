package edu.icet.controller;

import edu.icet.model.dto.payment.PaymentRequestDto;
import edu.icet.model.dto.payment.PaymentResponseDto;
import edu.icet.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
@CrossOrigin
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;


    @PostMapping("/process")
    public ResponseEntity<PaymentResponseDto> processPayment(@RequestBody PaymentRequestDto request) {
        return ResponseEntity.ok(paymentService.processPayment(request));
    }


    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<PaymentResponseDto>> getPaymentsByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(paymentService.getPaymentsByCustomerId(customerId));
    }


    @GetMapping("/all")
    public ResponseEntity<List<PaymentResponseDto>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }
}