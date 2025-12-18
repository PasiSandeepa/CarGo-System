package edu.icet.service;

import edu.icet.model.dto.booking.BookingRequestDto;

public interface BookingService {
    void addBooking(BookingRequestDto bookingRequestDto);
}
