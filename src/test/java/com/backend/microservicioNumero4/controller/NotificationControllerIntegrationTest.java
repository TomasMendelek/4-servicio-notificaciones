package com.backend.microservicioNumero4.controller;
import com.backend.microservicioNumero4.models.Notification;
import com.backend.microservicioNumero4.service.NotificationService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(NotificationController.class)
@AutoConfigureMockMvc(addFilters = false)
public class NotificationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NotificationService notificationService; // Se simula el servicio en lugar de cargarlo desde el contexto

    @Test
    public void testGetNotificationsByUserId() throws Exception {
        when(notificationService.getNotificationsByUserId("user1")).thenReturn(List.of(
                new Notification(), new Notification() // Notificaciones vacías para simplificar
        ));

        mockMvc.perform(get("/api/notifications/user1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2)); // Verifica que devuelve dos notificaciones
    }

    @Test
    public void testCreateNotification() throws Exception {
        Notification notification = new Notification();
        when(notificationService.createNotification(notification)).thenReturn(notification);

        mockMvc.perform(post("/api/notifications")
                        .contentType("application/json")
                        .content("{\"userId\":\"user2\", \"message\":\"Nueva notificación\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testMarkAsRead() throws Exception {
        doNothing().when(notificationService).markAsRead("4");

        mockMvc.perform(put("/api/notifications/4/read"))
                .andExpect(status().isOk());
    }
}