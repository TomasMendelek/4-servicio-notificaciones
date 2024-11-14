package com.backend.microservicioNumero4.models;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Chats")
public class Chat {
    @Id
    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private String chatName;
    private Boolean isGroupChat;
    private List<String> participants;
    private List<Message> messages;

    // Constructor
    public Chat(String id, LocalDateTime createdAt, LocalDateTime updateAt, String chatName, Boolean isGroupChat,
            List<String> participants, List<Message> messages) {
        this.id = id;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.chatName = chatName;
        this.isGroupChat = isGroupChat;
        this.participants = participants;
        this.messages = messages;
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public Boolean getIsGroupChat() {
        return isGroupChat;
    }

    public void setIsGroupChat(Boolean isGroupChat) {
        this.isGroupChat = isGroupChat;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
