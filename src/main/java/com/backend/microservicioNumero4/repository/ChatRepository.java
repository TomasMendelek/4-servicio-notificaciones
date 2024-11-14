package com.backend.microservicioNumero4.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.microservicioNumero4.models.Chat;

public interface ChatRepository extends MongoRepository<Chat, Integer>{


}
