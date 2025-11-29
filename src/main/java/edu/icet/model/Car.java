package edu.icet.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    private long carid;
    private  String brand;
    private  String model;
    private  String color;
    private  int year;
    private  double pricePerDay;
    private String type;
    private int seats;
    private String fuelType;
    private String registrationNo;
    private Double engineCapacity;
    private Boolean available = true;
}
