package com.backend.microservicioNumero4.repositories;

import com.backend.microservicioNumero4.models.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRepository extends MongoRepository<Chat, String> {
}
