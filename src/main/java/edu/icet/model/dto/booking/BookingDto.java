package edu.icet.model.dto.booking;

import edu.icet.model.dto.car.CarDto;
import edu.icet.model.dto.customer.CustomerDto;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingDto {
    private Long bookid;
    private CustomerDto customerid;
    private CarDto carid;
    private String bookingDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalAmount;
    private String bookingStatus;


}
