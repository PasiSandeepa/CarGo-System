package edu.icet.controller;

import edu.icet.model.dto.booking.BookingRequestDto;
import edu.icet.model.dto.booking.BookingResponseDto;
import edu.icet.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/booking")
@CrossOrigin
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/add")
    public ResponseEntity<String> addBooking(@RequestBody BookingRequestDto dto) {
        bookingService.addBooking(dto);
        return ResponseEntity.ok("Booking Added Successfully");
    }

    @GetMapping("/get-all")
    public List<BookingResponseDto> getAllBookings() {
        return bookingService.getAllBookings();
    }
}
