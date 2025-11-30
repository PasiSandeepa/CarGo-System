package edu.icet.model.dto.notification;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NotificationResponseDto {
    private Long notificationId;
    private String message;
    private String state;
    private String sendDate;
}
