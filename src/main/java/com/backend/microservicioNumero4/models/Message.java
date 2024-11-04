package com.backend.microservicioNumero4.models;

import java.security.Timestamp;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.w3c.dom.Text;


@Document
public class Message {

    @Id
    private UUID senderId;
    private UUID receiverId;
    private UUID chatId;
    private Text content;
    private Timestamp createdAt;

     // Getters
     public UUID getSenderId() {
        return senderId;
    }

    public UUID getReceiverId() {
        return receiverId;
    }

    public UUID getChatId() {
        return chatId;
    }

    public Text getContent() {
        return content;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    // Setters
    public void setSenderId(UUID senderId) {
        this.senderId = senderId;
    }

    public void setReceiverId(UUID receiverId) {
        this.receiverId = receiverId;
    }

    public void setChatId(UUID chatId) {
        this.chatId = chatId;
    }

    public void setContent(Text content) {
        this.content = content;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}





