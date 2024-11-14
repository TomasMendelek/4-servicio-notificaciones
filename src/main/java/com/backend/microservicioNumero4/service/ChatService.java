package com.backend.microservicioNumero4.service;

import com.backend.microservicioNumero4.models.Chat;
import com.backend.microservicioNumero4.models.Message;
import com.backend.microservicioNumero4.repositories.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;

    public Chat createChat(Chat chat) {
        chat.setCreatedAt(LocalDateTime.now());
        chat.setUpdateAt(LocalDateTime.now());
        return chatRepository.save(chat);
    }

    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    public Optional<Chat> getChatById(String id) {
        return chatRepository.findById(id);
    }

    public Chat addMessageToChat(String chatId, Message message) {
        Chat chat = chatRepository.findById(chatId).orElseThrow();
        message.setTimestamp(LocalDateTime.now());
        chat.getMessages().add(message);
        chat.setUpdateAt(LocalDateTime.now());
        return chatRepository.save(chat);
    }
}
