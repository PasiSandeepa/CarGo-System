package edu.icet.entity;

import edu.icet.model.entity.Booking;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private String phoneNumber;
    private String address;

    @Column(unique = true)
    private String nic;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @Column(nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role = "CUSTOMER";
}