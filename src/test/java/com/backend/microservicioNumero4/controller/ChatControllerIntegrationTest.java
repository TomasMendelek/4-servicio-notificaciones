package com.backend.microservicioNumero4.controller;

import com.backend.microservicioNumero4.models.Chat;
import com.backend.microservicioNumero4.models.Message;
import com.backend.microservicioNumero4.service.ChatService;
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

@WebMvcTest(ChatController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ChatControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChatService chatService;

    @Test
    public void testGetAllChats() throws Exception {
        List<Chat> chats = List.of(
            new Chat("1", LocalDateTime.now(), LocalDateTime.now(), "Chat 1", true, List.of("user1"), List.of()),
            new Chat("2", LocalDateTime.now(), LocalDateTime.now(), "Chat 2", false, List.of("user2"), List.of())
        );

        when(chatService.getAllChats()).thenReturn(chats);

        mockMvc.perform(get("/api/chats"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void testAddMessageToChat() throws Exception {
        Chat chat = new Chat("1", LocalDateTime.now(), LocalDateTime.now(), "Chat de prueba", true, List.of("user1", "user2"), List.of());
        Message message = new Message("1", "user1", "user2", "Hola, mundo!", LocalDateTime.now());
        chat.getMessages().add(message);

        when(chatService.addMessageToChat("1", message)).thenReturn(chat);

        mockMvc.perform(post("/api/chats/1/messages")
                        .contentType("application/json")
                        .content("{\"id\":\"1\", \"senderId\":\"user1\", \"receiverId\":\"user2\", \"content\":\"Hola, mundo!\", \"timestamp\":\"2023-11-10T10:00:00\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.messages[0].content").value("Hola, mundo!"));
    }
}