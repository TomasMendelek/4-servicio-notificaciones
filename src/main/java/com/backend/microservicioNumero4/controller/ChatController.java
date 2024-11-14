package com.backend.microservicioNumero4.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.microservicioNumero4.models.Chat;
import com.backend.microservicioNumero4.service.ChatService;


@RestController
@RequestMapping("/chats")
public class ChatController {
    
    @Autowired ChatService chatService;

    @PostMapping
    public Chat createChat(@RequestBody Chat chat) {
        return chatService.createChat(chat);
    }

    @GetMapping
    public List<Chat> getAllChats() {
        return chatService.getAllChats();
    }

    @GetMapping("/{id}")
    public Optional<Chat> getChatById(@PathVariable Integer id) {
        return chatService.getChatById(id);
    }

    @PutMapping("/{id}")
    public Chat updateChat(@PathVariable Integer id, @RequestBody Chat chat) {
        return chatService.updateChat(id, chat);
    }
}
