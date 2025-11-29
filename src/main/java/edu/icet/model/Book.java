package edu.icet.model;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private Long bookid;
    private Customer customerid;
    private Car carid;
    private String bookingDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double totalAmount;
    private String bookingStatus;

}
