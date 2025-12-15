package edu.icet.controller;

import edu.icet.model.dto.car.CarRequestDto;
import edu.icet.model.dto.car.CarResponseDto;
import edu.icet.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor
@CrossOrigin
public class CarController {

    private final CarService carService;

    @PostMapping
    public CarResponseDto saveCar(@RequestBody CarRequestDto dto) {
        return carService.saveCar(dto);
    }

    @GetMapping("/{id}")
    public CarResponseDto getCar(@PathVariable long id) {
        return carService.getCar(id);
    }

    @GetMapping("/All")
    public List<CarResponseDto> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/available")
    public List<CarResponseDto> getAvailableCars() {
        return carService.getAvailableCars();
    }

    @PutMapping("/{id}")
    public CarResponseDto updateCar(@PathVariable long id, @RequestBody CarRequestDto dto) {
        return carService.updateCar(id, dto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCar(@PathVariable long id) {
        return carService.deleteCar(id);
    }
}
