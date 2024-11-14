package com.backend.microservicioNumero4.repositories;

import com.backend.microservicioNumero4.models.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification, String> {
    List<Notification> findByUserId(String userId);
}
