package edu.icet.model.dto.booking;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookingRequestDto {
    private Long customerId;
    private Long carId;
    private LocalDate startDate;
    private LocalDate endDate;

}
