package edu.icet.service.impl;

import edu.icet.model.dto.payment.PaymentRequestDto;
import edu.icet.model.dto.payment.PaymentResponseDto;
import edu.icet.model.dto.notification.NotificationRequestDto;
import edu.icet.model.entity.Payment;
import edu.icet.repository.PaymentRepository;
import edu.icet.service.PaymentService;
import edu.icet.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final NotificationService notificationService;
    private final ModelMapper mapper;

    @Override
    public PaymentResponseDto processPayment(PaymentRequestDto request) {


        Payment entity = new Payment();
        entity.setBookingId(request.getBookingId());
        entity.setCustomerId(request.getCustomerId());
        entity.setAmount(request.getAmount());
        entity.setPaymentMethod(request.getPaymentMethod());
        entity.setPaymentDate(LocalDateTime.now());
        entity.setStatus("SUCCESS");
        entity.setTransactionId("TXN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());

        Payment savedPayment = paymentRepository.save(entity);


        NotificationRequestDto adminNote = new NotificationRequestDto();
        adminNote.setCustomerId(request.getCustomerId()); // නිවැරදි Customer ID එක
        adminNote.setBookingId(request.getBookingId());

        String msg = String.format("💰 PAYMENT RECEIVED: LKR %.2f for Booking ID: %d",
                request.getAmount(), request.getBookingId());

        adminNote.setMessage(msg);
        notificationService.createNotification(adminNote);

        return mapper.map(savedPayment, PaymentResponseDto.class);
    }

    @Override
    public List<PaymentResponseDto> getPaymentsByCustomerId(Long customerId) {
        return paymentRepository.findByCustomerId(customerId)
                .stream()
                .map(entity -> mapper.map(entity, PaymentResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PaymentResponseDto> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(entity -> mapper.map(entity, PaymentResponseDto.class))
                .collect(Collectors.toList());
    }
}