package edu.icet.model.dto.payment;

import edu.icet.model.dto.customer.CustomerDto;
import lombok.*;

import java.time.LocalDateTime;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentDto {
    private Long paymentId;
    private String paymentMethod;
    private double amount;
    private Long bookingId;
    private  String transactionId;
    private LocalDateTime paymentDate = LocalDateTime.now();
    private CustomerDto customer;
    private String status;
}
