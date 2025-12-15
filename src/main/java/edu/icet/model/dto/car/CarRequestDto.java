package edu.icet.model.dto.car;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarRequestDto {
    private String brand;
    private String model;
    private String color;
    private Integer year;
    private Double pricePerDay;
    private String type;
    private Integer seats;
    private String fuelType;
    private String registrationNo;
    private Double engineCapacity;

    @JsonProperty("pickup_lat")
    private Double pickupLat;

    @JsonProperty("pickup_lng")
    private Double pickupLng;

    @JsonProperty("pickup_address")
    private String pickupAddress;

    private Boolean available;

    @JsonProperty("image_url")
    private String imageUrl;
}
