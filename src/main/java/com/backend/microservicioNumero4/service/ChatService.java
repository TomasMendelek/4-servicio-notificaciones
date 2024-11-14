package com.backend.microservicioNumero4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.microservicioNumero4.models.Chat;
import com.backend.microservicioNumero4.repository.ChatRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    // Crear un nuevo chat
    public Chat createChat(Chat chat) {
        chat.setCreatedAt(LocalDateTime.now());
        chat.setUpdateAt(LocalDateTime.now());
        return chatRepository.save(chat);
    }

    // Obtener todos los chats
    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    // Obtener un chat por ID
    public Optional<Chat> getChatById(Integer id) {
        return chatRepository.findById(id);
    }

    // Actualizar un chat
    public Chat updateChat(Integer id, Chat chat) {
        if (chatRepository.existsById(id)) {
            chat.setId(id);
            chat.setUpdateAt(LocalDateTime.now());
            return chatRepository.save(chat);
        } else {
            return null;  // Si el chat no existe
        }
    }
}
