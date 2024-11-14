# Microservicio N°4 Notificaciones y Mensajeria

### **Documentacion**
- [Plan De Pruebas](./plandepruebas.md)
- [Estrategias De Pruebas](./estrategiasdepruebas.md)
- [Politica De Pruebas](./politicadepruebas.md)

### **Endpoints**
**URL:** https://4-servicio-notificaciones-production.up.railway.app/

### **POST /api/chats**
- **Descripción**: Crea un nuevo chat.
- **Request Body**:
    ```json
    {
        "userId": "string",
        "chatName": "string"
    }
    ```
- **Respuesta**:
    - Código de estado: `201 Created`
    - Body:
    ```json
    {
        "id": "string",
        "userId": "string",
        "chatName": "string"
    }
    ```

### **GET /api/chats**
- **Descripción**: Obtiene todos los chats.
- **Respuesta**:
    - Código de estado: `200 OK`
    - Body:
    ```json
    [
        {
            "id": "string",
            "userId": "string",
            "chatName": "string"
        }
    ]
    ```

### **GET /api/chats/{id}**
- **Descripción**: Obtiene un chat por su ID.
- **Parámetros**:
    - `id` (path variable): ID del chat.
- **Respuesta**:
    - Código de estado: `200 OK`
    - Body:
    ```json
    {
        "id": "string",
        "userId": "string",
        "chatName": "string"
    }
    ```

### **POST /api/chats/{id}/messages**
- **Descripción**: Añade un mensaje a un chat específico.
- **Parámetros**:
    - `id` (path variable): ID del chat al que se añadirá el mensaje.
- **Request Body**:
    ```json
    {
        "senderId": "string",
        "content": "string",
        "timestamp": "string"
    }
    ```
- **Respuesta**:
    - Código de estado: `200 OK`
    - Body:
    ```json
    {
        "id": "string",
        "senderId": "string",
        "content": "string",
        "timestamp": "string",
        "chatId": "string"
    }
    ```

---

### **GET /api/messages/{receiverId}**
- **Descripción**: Obtiene todos los mensajes para un receptor específico.
- **Parámetros**:
    - `receiverId` (path variable): ID del receptor de los mensajes.
- **Respuesta**:
    - Código de estado: `200 OK`
    - Body:
    ```json
    [
        {
            "id": "string",
            "senderId": "string",
            "receiverId": "string",
            "content": "string",
            "timestamp": "string"
        }
    ]
    ```

### **POST /api/messages**
- **Descripción**: Envía un nuevo mensaje.
- **Request Body**:
    ```json
    {
        "senderId": "string",
        "receiverId": "string",
        "content": "string",
        "timestamp": "string"
    }
    ```
- **Respuesta**:
    - Código de estado: `201 Created`
    - Body:
    ```json
    {
        "id": "string",
        "senderId": "string",
        "receiverId": "string",
        "content": "string",
        "timestamp": "string"
    }
    ```

---

## **NotificationController**

### **GET /api/notifications/{userId}**
- **Descripción**: Obtiene todas las notificaciones para un usuario específico.
- **Parámetros**:
    - `userId` (path variable): ID del usuario para el cual obtener las notificaciones.
- **Respuesta**:
    - Código de estado: `200 OK`
    - Body:
    ```json
    [
        {
            "id": "string",
            "userId": "string",
            "message": "string",
            "read": false,
            "timestamp": "string"
        }
    ]
    ```

### **POST /api/notifications**
- **Descripción**: Crea una nueva notificación.
- **Request Body**:
    ```json
    {
        "userId": "string",
        "message": "string",
        "read": false,
        "timestamp": "string"
    }
    ```
- **Respuesta**:
    - Código de estado: `201 Created`
    - Body:
    ```json
    {
        "id": "string",
        "userId": "string",
        "message": "string",
        "read": false,
        "timestamp": "string"
    }
    ```

### **PUT /api/notifications/{id}/read**
- **Descripción**: Marca una notificación como leída.
- **Parámetros**:
    - `id` (path variable): ID de la notificación a marcar como leída.
- **Respuesta**:
    - Código de estado: `200 OK`
    - Sin body.
