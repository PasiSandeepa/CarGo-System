package edu.icet.model;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Customer {
    private Long id;
    private  String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;
    private String status;
    private LocalDateTime createdAt = LocalDateTime.now();
}
