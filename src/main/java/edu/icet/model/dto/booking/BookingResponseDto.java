package edu.icet.model.dto.booking;

import edu.icet.model.dto.car.CarDto;
import edu.icet.model.dto.customer.CustomerDto;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookingResponseDto {
    private Long bookId;
    private CustomerDto customer;
    private CarDto car;
    private LocalDate bookingDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalAmount;
    private String bookingStatus;
}
