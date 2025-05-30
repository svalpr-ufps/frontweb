package co.edu.frontend.controller;

import co.edu.frontend.model.MessageRequest;
import co.edu.frontend.model.MessageResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.*;

@WebServlet("/messages")
public class MessageController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final UUID USER_ID = UUID.fromString("11111111-1111-1111-1111-111111111111");
    private static final String BACKEND_URL = "http://localhost:8080/api/messages";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("form".equals(action)) {
            req.getRequestDispatcher("/WEB-INF/views/message/form.jsp").forward(req, resp);
        } else {
            List<MessageResponse> messages = fetchMessages();
            req.setAttribute("messages", messages);
            req.getRequestDispatcher("/WEB-INF/views/message/list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MessageRequest request = new MessageRequest();
        request.setReceiverId(UUID.fromString(req.getParameter("receiverId")));
        request.setContent(req.getParameter("content"));

        sendMessageToBackend(request);
        resp.sendRedirect("messages");
    }

    private void sendMessageToBackend(MessageRequest request) throws IOException {
        URL url = new URL(BACKEND_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("X-User-Id", USER_ID.toString()); // En lugar de @AuthenticationPrincipal
        connection.setDoOutput(true);

        String jsonInput = objectMapper.writeValueAsString(request);
        try (OutputStream os = connection.getOutputStream()) {
            os.write(jsonInput.getBytes());
        }

        if (connection.getResponseCode() != 200) {
            throw new IOException("Error enviando mensaje: " + connection.getResponseCode());
        }

        connection.disconnect();
    }

    private List<MessageResponse> fetchMessages() throws IOException {
        URL url = new URL(BACKEND_URL + "/received");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("X-User-Id", USER_ID.toString());
        connection.setRequestMethod("GET");

        try (InputStream inputStream = connection.getInputStream()) {
            return objectMapper.readValue(inputStream, new TypeReference<List<MessageResponse>>() {});
        }
    }
}
