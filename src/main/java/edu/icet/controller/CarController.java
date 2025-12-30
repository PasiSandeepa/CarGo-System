package edu.icet.controller;

import edu.icet.model.dto.car.CarRequestDto;
import edu.icet.model.dto.car.CarResponseDto;
import edu.icet.service.CarService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @GetMapping("/all")
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

    @GetMapping("/image-proxy")
    public ResponseEntity<byte[]> imageProxy(@RequestParam String url) {
        try {
            URL imageUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) imageUrl.openConnection();


            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
            connection.setRequestProperty("Referer", "https://www.google.com/");

            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                return ResponseEntity.status(responseCode).build();
            }

            try (InputStream inputStream = connection.getInputStream()) {
                byte[] imageBytes = inputStream.readAllBytes();
                String contentType = connection.getContentType();
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_TYPE, contentType != null ? contentType : "image/jpeg")
                        .body(imageBytes);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}