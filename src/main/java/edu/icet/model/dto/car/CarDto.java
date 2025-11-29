package edu.icet.model.dto.car;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarDto {
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
