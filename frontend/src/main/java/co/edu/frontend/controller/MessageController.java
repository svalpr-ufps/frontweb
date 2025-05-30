package co.edu.frontend.controller;

import co.edu.frontend.model.MessageRequest;
import co.edu.frontend.model.MessageResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@WebServlet("/messages")
public class MessageController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final List<MessageResponse> messages = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("form".equals(action)) {
            req.getRequestDispatcher("/WEB-INF/views/message/form.jsp").forward(req, resp);
        } else {
            req.setAttribute("messages", messages);
            req.getRequestDispatcher("/WEB-INF/views/message/list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MessageRequest request = new MessageRequest();
        request.setReceiverId(UUID.fromString(req.getParameter("receiverId")));
        request.setContent(req.getParameter("content"));

        MessageResponse response = new MessageResponse();
        response.setId(UUID.randomUUID());
        response.setSenderName("Usuario Actual");
        response.setReceiverName("Destinatario");
        response.setContent(request.getContent());
        response.setSentAt(LocalDateTime.now());
        response.setRead(false);

        messages.add(response);

        resp.sendRedirect("messages");
    }
}
