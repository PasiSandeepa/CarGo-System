package edu.icet.controller;

import edu.icet.model.dto.booking.BookingRequestDto;
import edu.icet.model.dto.booking.BookingResponseDto;
import edu.icet.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/booking")
@CrossOrigin
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/add")
    public ResponseEntity<?> addBooking(@RequestBody BookingRequestDto dto) {
        try {
            bookingService.addBooking(dto);
            return ResponseEntity.ok("Booking Added Successfully");
        } catch (IllegalArgumentException e) {

            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (Exception e) {

            return ResponseEntity.internalServerError().body("Server Error: " + e.getMessage());
        }
    }

    @GetMapping("/get-all")
    public List<BookingResponseDto> getAllBookings() {
        return bookingService.getAllBookings();
    }
    @PutMapping("/cancel/{id}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
        return ResponseEntity.ok("Booking Cancelled");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok("Booking Deleted");
    }

    @GetMapping("/get-by-customer/{customerId}")
    public List<BookingResponseDto> getBookingsByCustomerId(@PathVariable Long customerId) {
        return bookingService.getBookingsByCustomerId(customerId);
    }
}
