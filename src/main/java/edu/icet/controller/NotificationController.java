package edu.icet.controller;

import edu.icet.model.dto.notification.NotificationResponseDto;
import edu.icet.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/notifications")

public class NotificationController {

    private  final NotificationService notificationService;

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<NotificationResponseDto>> getNotifications(@PathVariable Long customerId) {
        return ResponseEntity.ok(notificationService.getNotificationsByCustomer(customerId));
    }
    @PutMapping("/read/{id}")
    public ResponseEntity<Void> markAsRead(@PathVariable Long id) {
        notificationService.markAsRead(id);
        return ResponseEntity.ok().build();
    }
}
