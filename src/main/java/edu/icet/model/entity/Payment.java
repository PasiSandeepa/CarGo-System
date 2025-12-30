package edu.icet.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private Long bookingId;
    private Long customerId;
    private Double amount;
    private String paymentMethod;
    private String status;
    private LocalDateTime paymentDate;

    @Column(unique = true)
    private String transactionId;

}
