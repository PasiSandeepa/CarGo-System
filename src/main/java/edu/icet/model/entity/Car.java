package edu.icet.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carid;

    private String brand;
    private String model;
    private String color;
    private Integer year = 0;

    @Column(name = "priceperday")
    private Double pricePerDay = 0.0;

    private String type;
    private Integer seats;
    private String fuelType;

    @Column(name = "registration_no")
    private String registrationNo;

    @Column(name = "engine_capacity")
    private Double engineCapacity = 0.0;

    @Column(name = "pickup_lat")
    private Double pickupLat = 0.0;

    @Column(name = "pickup_lng")
    private Double pickupLng = 0.0;

    @Column(name = "pickup_address")
    private String pickupAddress = "";

    @Column(columnDefinition = "bit(1) default 1")
    private Boolean available = true;

    @Column(name = "image_url")
    private String imageUrl = "";

    private String transmission;
}
