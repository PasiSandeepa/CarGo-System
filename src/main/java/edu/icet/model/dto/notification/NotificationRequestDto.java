package edu.icet.model.dto.notification;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NotificationRequestDto {
    private Long customerId;
    private Long bookingId;
    private String message;
}
