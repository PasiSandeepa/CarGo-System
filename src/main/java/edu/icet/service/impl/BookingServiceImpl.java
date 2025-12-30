package edu.icet.service.impl;

import edu.icet.model.dto.booking.BookingRequestDto;
import edu.icet.model.dto.booking.BookingResponseDto;

import edu.icet.model.dto.notification.NotificationRequestDto;
import edu.icet.model.entity.Booking;
import edu.icet.model.entity.Car;
import edu.icet.repository.BookRepository;
import edu.icet.repository.CarRepository;
import edu.icet.repository.CustomerRepository;
import edu.icet.service.BookingService;
import edu.icet.service.NotificationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {

    private final ModelMapper modelMapper;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final BookRepository bookRepository;
    private final NotificationService notificationService;

    @Transactional
    @Override
    public BookingResponseDto addBooking(BookingRequestDto dto) {
        Booking entity = new Booking();


        edu.icet.entity.Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Car car = carRepository.findById(dto.getCarId())
                .orElseThrow(() -> new RuntimeException("Car not found"));


        entity.setCustomer(customer);
        entity.setCar(car);
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
        entity.setTotalAmount(dto.getTotalAmount());
        entity.setBookingStatus("CONFIRMED");
        entity.setBookingDate(LocalDate.now());


        car.setAvailable(false);
        carRepository.save(car);


        Booking savedBooking = bookRepository.save(entity);


        if (savedBooking != null) {

            NotificationRequestDto customerNote = new NotificationRequestDto();
            customerNote.setCustomerId(dto.getCustomerId());
            customerNote.setBookingId(savedBooking.getBookId());
            customerNote.setMessage("Your " + car.getModel() + " Booking Succesfully! (Booking ID: #" + savedBooking.getBookId() + ")");
            notificationService.createNotification(customerNote);


            NotificationRequestDto adminNote = new NotificationRequestDto();
            adminNote.setCustomerId(5L);
            adminNote.setBookingId(savedBooking.getBookId());
            adminNote.setMessage("Got a new booking.ා! Customer: " + customer.getFirstName() + " " + customer.getLastName());
            notificationService.createNotification(adminNote);
        }
        return modelMapper.map(savedBooking, BookingResponseDto.class);
    }
    @Override
    public List<BookingResponseDto> getAllBookings() {
        return bookRepository.findAll().stream()
                .map(booking -> {
                    return modelMapper.map(booking, BookingResponseDto.class);
                })
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void cancelBooking(Long bookingId) {
        Booking booking = bookRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setBookingStatus("CANCELLED");

        Car car = booking.getCar();
        car.setAvailable(true);
        carRepository.save(car);
        bookRepository.save(booking);
    }

    @Transactional
    @Override
    public void deleteBooking(Long bookingId) {
        Booking booking = bookRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        if (!"CANCELLED".equals(booking.getBookingStatus())) {
            Car car = booking.getCar();
            car.setAvailable(true);
            carRepository.save(car);
        }
        bookRepository.delete(booking);
    }

    @Override
    public List<BookingResponseDto> getBookingsByCustomerId(Long customerId) {
        return bookRepository.findAll().stream()
                .filter(booking -> booking.getCustomer().getCustomerId().equals(customerId))
                .map(booking -> modelMapper.map(booking, BookingResponseDto.class))
                .collect(Collectors.toList());
    }

}