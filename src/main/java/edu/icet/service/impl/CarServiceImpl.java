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

    @Override
    public List<CarResponseDto> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(car -> modelMapper.map(car, CarResponseDto.class))
                .toList();
    }

    @Override
    public List<CarResponseDto> getAvailableCars() {
        return carRepository.findAvailableCars()
                .stream()
                .map(car -> modelMapper.map(car, CarResponseDto.class))
                .toList();
    }

    @Override
    public CarResponseDto updateCar(Long id, CarRequestDto dto) {
        Car car = carRepository.findById(id).orElse(null);

        if (car == null) {
            return null;
        }

        modelMapper.map(dto, car);
        carRepository.save(car);

        return modelMapper.map(car, CarResponseDto.class);
    }

    @Override
    public boolean deleteCar(Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
