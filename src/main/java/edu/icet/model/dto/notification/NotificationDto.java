package edu.icet.model.dto.notification;

import java.time.LocalDateTime;

public class NotificationDto {

    private Long notificationId;
    private Long customerId;
    private Long bookingId;

    private String message;
    private String state;
    private LocalDateTime sendDate;

}
