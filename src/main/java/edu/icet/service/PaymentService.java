package edu.icet.service;

import edu.icet.model.dto.payment.PaymentRequestDto;
import edu.icet.model.dto.payment.PaymentResponseDto;

import java.util.List;

public interface PaymentService {
    PaymentResponseDto processPayment(PaymentRequestDto request);
    List<PaymentResponseDto> getPaymentsByCustomerId(Long customerId);
    List<PaymentResponseDto> getAllPayments();
}
