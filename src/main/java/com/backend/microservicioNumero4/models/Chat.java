package com.backend.microservicioNumero4.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Chats")
public class Chat {
    @Id
    private Integer id;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private String chatName;
    private Boolean isGroupChat;

    
    // Getters
    public Chat(Integer id, LocalDateTime createdAt, LocalDateTime updateAt, String chatName, Boolean isGroupChat) {
        this.id = id;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.chatName = chatName;
        this.isGroupChat = isGroupChat;
    }

    public String getChatName() {
        return chatName;
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

    public Boolean getIsGroupChat() {
        return isGroupChat;
    }

    // Setters
    

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }


    public void setIsGroupChat(Boolean isGroupChat) {
        this.isGroupChat = isGroupChat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
