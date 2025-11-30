package edu.icet.model.dto.notification;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NotificationDto {

    private Long notificationId;
    private Long customerId;
    private Long bookingId;
    private String message;
    private String state;
    private LocalDateTime sendDate;

}
