package edu.icet.model.dto.customer;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerResponseDto {
    private Long customerid;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String status;
    private LocalDateTime createdAt;
}
