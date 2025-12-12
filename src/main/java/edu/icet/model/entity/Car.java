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
    private Long carid;
    private  String brand;
    private  String model;
    private  String color;
    private Integer year;
    private Double pricePerDay;
    private String type;
    private Integer seats;
    private String fuelType;
    private String registrationNo;
    private Double engineCapacity;
    private Double pickupLat;
    private Double pickupLng;
    private String pickupAddress;
    private Boolean available = true;
}
