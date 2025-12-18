package edu.icet.model.dto.customer;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class CustomerDto {
    private Long customerid;
    private  String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;
    private String status;
    private LocalDateTime createdAt = LocalDateTime.now();
    private String nic;
}
