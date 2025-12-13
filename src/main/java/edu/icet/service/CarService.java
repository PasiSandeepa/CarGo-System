package edu.icet.service;

import edu.icet.model.dto.car.CarRequestDto;
import edu.icet.model.dto.car.CarResponseDto;

import java.util.List;


public interface CarService {
    CarResponseDto saveCar(CarRequestDto dto);
   CarResponseDto getCar(Long id);
//    List<CarResponseDto>getAllCars();
//    List<CarResponseDto>getAvailableCars();
//    CarResponseDto updateCar(Long id, CarRequestDto dto);
//    boolean deleteCar(Long id);
}
