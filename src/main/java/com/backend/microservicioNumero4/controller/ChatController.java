package com.backend.microservicioNumero4.controller;

import com.backend.microservicioNumero4.models.Chat;
import com.backend.microservicioNumero4.models.Message;
import com.backend.microservicioNumero4.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chats")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping
    public Chat createChat(@RequestBody Chat chat) {
        return chatService.createChat(chat);
    }

    @GetMapping
    public List<Chat> getAllChats() {
        return chatService.getAllChats();
    }

    @GetMapping("/{id}")
    public Optional<Chat> getChatById(@PathVariable String id) {
        return chatService.getChatById(id);
    }

    @PostMapping("/{id}/messages")
    public Chat addMessageToChat(@PathVariable String id, @RequestBody Message message) {
        return chatService.addMessageToChat(id, message);
    }
}
