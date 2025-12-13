package edu.icet.service.impl;

import edu.icet.model.dto.car.CarRequestDto;
import edu.icet.model.dto.car.CarResponseDto;
import edu.icet.model.entity.Car;
import edu.icet.repository.CarRepository;
import edu.icet.service.CarService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final ModelMapper modelMapper;
    private final CarRepository carRepository;

    @Override
    public CarResponseDto saveCar(CarRequestDto dto) {
        Car car = modelMapper.map(dto, Car.class);
        carRepository.save(car);
        return modelMapper.map(car, CarResponseDto.class);
    }

    @Override
    public CarResponseDto getCar(Long id) {
        Car car = carRepository.findById(id).orElse(null);
        if (car == null) {
            return null;
        }
        return modelMapper.map(car, CarResponseDto.class);
    }


}
