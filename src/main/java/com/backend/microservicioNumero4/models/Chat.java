package com.backend.microservicioNumero4.models;

import java.security.Timestamp;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Chat {

    @Id
    
    private String chatName;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Boolean isGroupChat;


    // Getters
   

    public String getChatName() {
        return chatName;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public Boolean getIsGroupChat() {
        return isGroupChat;
    }

    // Setters
    

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setIsGroupChat(Boolean isGroupChat) {
        this.isGroupChat = isGroupChat;
    }











}
