package edu.icet.service;

import edu.icet.model.dto.notification.NotificationRequestDto;

public interface NotificationService {
   void createNotification(NotificationRequestDto requestDto);
}
