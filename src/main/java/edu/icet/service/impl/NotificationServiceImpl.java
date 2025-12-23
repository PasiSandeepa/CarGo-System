package edu.icet.service.impl;

import edu.icet.model.dto.notification.NotificationRequestDto;
import edu.icet.repository.NotificationRepository;
import edu.icet.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public void createNotification(NotificationRequestDto requestDto) {
        edu.icet.entity.notification.Notification notification = modelMapper.map(requestDto, edu.icet.entity.notification.Notification.class);
        repository.save(notification);
    }
}
