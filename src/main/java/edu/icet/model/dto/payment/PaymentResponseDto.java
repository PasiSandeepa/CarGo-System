package edu.icet.model.dto.payment;

import edu.icet.model.dto.customer.CustomerDto;
import lombok.*;

import java.time.LocalDateTime;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentResponseDto {
    private Long paymentId;
    private Long bookingId;
    private CustomerDto customer;
    private Double amount;
    private String paymentMethod;
    private String status;
    private LocalDateTime paymentDate;
    private String transactionId;

}
