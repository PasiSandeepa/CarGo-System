package edu.icet.model.dto.booking;

import edu.icet.model.dto.Car;
import edu.icet.model.dto.Customer;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookingResponsedto {
    private Long bookId;
    private Customer customer;
    private Car car;
    private String bookingDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalAmount;
    private String bookingStatus;
}
