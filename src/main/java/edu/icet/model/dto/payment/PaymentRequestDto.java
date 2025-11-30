package edu.icet.model.dto.payment;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentRequestDto {
    private Long bookingId;
    private Long customerId;
    private Double amount;
    private String paymentMethod;

}
