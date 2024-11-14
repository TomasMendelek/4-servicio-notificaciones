package com.backend.microservicioNumero4.controller;

import com.backend.microservicioNumero4.models.Message;
import com.backend.microservicioNumero4.repositories.MessageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MessageController.class)
@AutoConfigureMockMvc(addFilters = false)
public class MessageControllerintegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageRepository messageRepository;

    @Test
    public void testGetMessagesByReceiverId() throws Exception {
        List<Message> messages = List.of(
            new Message("1", "user1", "user2", "Hola, usuario 2!", LocalDateTime.now()),
            new Message("2", "user3", "user2", "Hola otra vez, usuario 2!", LocalDateTime.now())
        );

        when(messageRepository.findByReceiverId("user2")).thenReturn(messages);

        mockMvc.perform(get("/api/messages/user2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].content").value("Hola, usuario 2!"))
                .andExpect(jsonPath("$[1].content").value("Hola otra vez, usuario 2!"));
    }

    @Test
    public void testSendMessage() throws Exception {
        Message message = new Message("3", "user1", "user4", "Mensaje para usuario 4", LocalDateTime.now());

        when(messageRepository.save(message)).thenReturn(message);

        mockMvc.perform(post("/api/messages")
                        .contentType("application/json")
                        .content("{\"id\":\"3\", \"senderId\":\"user1\", \"receiverId\":\"user4\", \"content\":\"Mensaje para usuario 4\", \"timestamp\":\"2023-11-10T10:00:00\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Mensaje para usuario 4"))
                .andExpect(jsonPath("$.receiverId").value("user4"));
    }
}