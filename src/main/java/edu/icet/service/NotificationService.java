package edu.icet.service;

import edu.icet.model.dto.notification.NotificationRequestDto;
import edu.icet.model.dto.notification.NotificationResponseDto;

import java.util.List;

public interface NotificationService {
   void createNotification(NotificationRequestDto requestDto);
   List<NotificationResponseDto> getNotificationsByCustomer(Long customerId);
}
