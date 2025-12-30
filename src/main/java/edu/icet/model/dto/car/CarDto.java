package edu.icet.model.dto.car;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarDto {

    private Long carid;

    private String brand;

    private String model;

    private String color;

    private Integer year;

    @JsonProperty("priceperday")
    private Double pricePerDay;

    private String type;

    private Integer seats;

    @JsonProperty("fuel_type")
    private String fuelType;

    @JsonProperty("registration_no")
    private String registrationNo;

    @JsonProperty("engine_capacity")
    private Double engineCapacity;


    private Double pickup_lat;
    private Double pickup_lng;
    private Boolean available = true;
    private String image_url;
    private String  pickup_address;
}