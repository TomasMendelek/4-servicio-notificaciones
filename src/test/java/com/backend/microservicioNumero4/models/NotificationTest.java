package com.backend.microservicioNumero4.models;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class NotificationTest {

    @Test
    public void testGettersAndSetters() {
        
        Notification notification = new Notification();
        
       
        String id = "notif123";
        String userId = "user1";
        String message = "This is a test notification.";
        LocalDateTime sentAt = LocalDateTime.now();
        boolean isRead = false;

      
        notification.setId(id);
        notification.setUserId(userId);
        notification.setMessage(message);
        notification.setSentAt(sentAt);
        notification.setRead(isRead);

        
        assertEquals(id, notification.getId());
        assertEquals(userId, notification.getUserId());
        assertEquals(message, notification.getMessage());
        assertEquals(sentAt, notification.getSentAt());
        assertEquals(isRead, notification.isRead());

        
        notification.setRead(true);
        assertTrue(notification.isRead());
    }
}
