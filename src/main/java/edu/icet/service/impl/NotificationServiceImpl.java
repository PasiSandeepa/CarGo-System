package edu.icet.service.impl;

import edu.icet.model.dto.notification.NotificationRequestDto;
import edu.icet.model.dto.notification.NotificationResponseDto;
import edu.icet.repository.NotificationRepository;
import edu.icet.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<NotificationResponseDto> getNotificationsByCustomer(Long customerId) {
        List<edu.icet.entity.notification.Notification> entities = repository.findByCustomerIdOrderBySendDateDesc(customerId);

        List<NotificationResponseDto> responseList = new ArrayList<>();


        for (edu.icet.entity.notification.Notification entity : entities) {
            responseList.add(modelMapper.map(entity, NotificationResponseDto.class));
        }

        return responseList;
    }
}
