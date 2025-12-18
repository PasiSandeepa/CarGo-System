package edu.icet.service.impl;

import edu.icet.model.dto.booking.BookingRequestDto;
import edu.icet.model.entity.Booking;
import edu.icet.model.entity.Car;
import edu.icet.repository.BookRepository;
import edu.icet.repository.CarRepository;
import edu.icet.repository.CustomerRepository;
import edu.icet.service.BookingService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@RequiredArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {

    private final ModelMapper modelMapper;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final BookRepository bookRepository;

    @Transactional
    @Override
    public void addBooking(BookingRequestDto bookingRequestDto) { // Void -> void ලෙස වෙනස් කළා
        Car car = carRepository.findById(bookingRequestDto.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found"));


        edu.icet.entity.Customer customer = customerRepository.findById(bookingRequestDto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));


        Booking bookingEntity = modelMapper.map(bookingRequestDto, Booking.class);


        bookingEntity.setCar(car);
        bookingEntity.setCustomer(customer);
        bookingEntity.setBookingDate(LocalDate.now());
        bookingEntity.setBookingStatus("CONFIRMED");


        car.setAvailable(false);
        carRepository.save(car);


        bookRepository.save(bookingEntity);
    }
}