package com.backend.microservicioNumero4.controller;

import com.backend.microservicioNumero4.models.Message;
import com.backend.microservicioNumero4.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/{receiverId}")
    public List<Message> getMessagesByReceiverId(@PathVariable String receiverId) {
        return messageService.getMessagesByReceiverId(receiverId);
    }

    @PostMapping
    public Message sendMessage(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }
}
