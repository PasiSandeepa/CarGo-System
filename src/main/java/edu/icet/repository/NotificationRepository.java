package edu.icet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<edu.icet.entity.notification.Notification, Long> {
    List<edu.icet.entity.notification.Notification> findByCustomerIdOrderBySendDateDesc(Long customerId);
}
