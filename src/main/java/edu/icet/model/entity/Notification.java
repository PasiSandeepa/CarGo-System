package edu.icet.entity.notification;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    @Column(nullable = false)
    private Long customerId;

    @Column(nullable = false)
    private Long bookingId;

    @Column(nullable = false, length = 500)
    private String message;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private LocalDateTime sendDate;


    @PrePersist
    protected void onCreate() {
        this.sendDate = LocalDateTime.now();
        if (this.state == null) {
            this.state = "UNREAD";
        }
    }
}