package com.backend.microservicioNumero4.service;

import com.backend.microservicioNumero4.models.Message;
import com.backend.microservicioNumero4.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getMessagesByReceiverId(String receiverId) {
        return messageRepository.findByReceiverId(receiverId);
    }

    public Message sendMessage(Message message) {
        return messageRepository.save(message);
    }
}
