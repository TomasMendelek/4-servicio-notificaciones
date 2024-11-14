package com.backend.microservicioNumero4.models;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testMessageConstructor() {
        String id = "1";
        String senderId = "user1";
        String receiverId = "user2";
        String content = "Hello, this is a test message.";
        LocalDateTime timestamp = LocalDateTime.now();

        Message message = new Message(id, senderId, receiverId, content, timestamp);

        assertEquals(id, message.getId());
        assertEquals(senderId, message.getSenderId());
        assertEquals(receiverId, message.getReceiverId());
        assertEquals(content, message.getContent());
        assertEquals(timestamp, message.getTimestamp());
    }

    @Test
    public void testSettersAndGetters() {
        Message message = new Message("1", "user1", "user2", "Test", LocalDateTime.now());

        message.setId("2");
        message.setSenderId("user3");
        message.setReceiverId("user4");
        message.setContent("Updated message content.");
        message.setTimestamp(LocalDateTime.now().plusMinutes(10));

        assertEquals("2", message.getId());
        assertEquals("user3", message.getSenderId());
        assertEquals("user4", message.getReceiverId());
        assertEquals("Updated message content.", message.getContent());
        assertNotNull(message.getTimestamp());
    }

    @Test
    public void testTimestampNotNull() {
        LocalDateTime timestamp = LocalDateTime.now();
        Message message = new Message("1", "user1", "user2", "Test", timestamp);

        assertNotNull(message.getTimestamp());
    }
}
