package edu.icet.service;

import edu.icet.model.dto.booking.BookingRequestDto;
import edu.icet.model.dto.booking.BookingResponseDto;
import edu.icet.model.entity.Booking;

import java.util.List;


public interface BookingService {
    BookingResponseDto addBooking(BookingRequestDto bookingRequestDto);

    List<BookingResponseDto> getAllBookings();

    void cancelBooking(Long bookingId);

    void deleteBooking(Long bookingId);

    List<BookingResponseDto> getBookingsByCustomerId(Long customerId);
}

