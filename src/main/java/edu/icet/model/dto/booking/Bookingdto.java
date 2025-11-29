package edu.icet.model.dto.booking;

import edu.icet.model.dto.Car;
import edu.icet.model.dto.Customer;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bookingdto {
    private Long bookid;
    private Customer customerid;
    private Car carid;
    private String bookingDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalAmount;
    private String bookingStatus;

}
