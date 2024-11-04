package com.backend.microservicioNumero4.models;

import java.security.Timestamp;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Notification {

    @Id
    private UUID userId;
    private Enum type;
    private UUID sourceId;
    private String message;
    private Boolean isRead;
    private Timestamp createdAt;

    // Getters
    public UUID getUserId() {
        return userId;
    }

    public Enum<?> getType() {
        return type;
    }

    public UUID getSourceId() {
        return sourceId;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    // Setters
    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setType(Enum<?> type) {
        this.type = type;
    }

    public void setSourceId(UUID sourceId) {
        this.sourceId = sourceId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }





}
