package com.backend.microservicioNumero4.repositories;

import com.backend.microservicioNumero4.models.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findByReceiverId(String receiverId);
}
