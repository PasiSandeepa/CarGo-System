package edu.icet.service;

import edu.icet.model.dto.booking.BookingRequestDto;
import edu.icet.model.dto.booking.BookingResponseDto;

import java.util.List;
import java.util.ListIterator;

public interface BookingService {
    void addBooking(BookingRequestDto bookingRequestDto);
    List <BookingResponseDto>getAllBookings();
    void cancelBooking(Long bookingId);
}
