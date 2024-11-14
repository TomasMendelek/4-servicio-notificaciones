package com.backend.microservicioNumero4.service;

import com.backend.microservicioNumero4.models.Notification;
import com.backend.microservicioNumero4.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getNotificationsByUserId(String userId) {
        return notificationRepository.findByUserId(userId);
    }

    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public void markAsRead(String id) {
        Notification notification = notificationRepository.findById(id).orElseThrow();
        notification.setRead(true);
        notificationRepository.save(notification);
    }
}
