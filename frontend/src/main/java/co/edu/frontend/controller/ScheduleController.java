package co.edu.frontend.controller;

import co.edu.frontend.model.ScheduleRequest;
import co.edu.frontend.model.ScheduleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

@WebServlet("/schedules")
public class ScheduleController extends HttpServlet {

    private static final String BACKEND_URL = "http://localhost:8080/api/schedules";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/schedule/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ScheduleRequest schedule = new ScheduleRequest();
        schedule.setCourseId(UUID.fromString(req.getParameter("courseId")));
        schedule.setRoomId(UUID.fromString(req.getParameter("roomId")));
        schedule.setDay(DayOfWeek.valueOf(req.getParameter("day").toUpperCase()));
        schedule.setStartTime(LocalTime.parse(req.getParameter("startTime")));
        schedule.setEndTime(LocalTime.parse(req.getParameter("endTime")));

        // Enviar al backend
        URL url = new URL(BACKEND_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        try (OutputStream os = connection.getOutputStream()) {
            String json = objectMapper.writeValueAsString(schedule);
            os.write(json.getBytes());
        }

        if (connection.getResponseCode() == 201) {
            ScheduleResponse response = objectMapper.readValue(connection.getInputStream(), ScheduleResponse.class);
            req.setAttribute("message", "Horario creado con ID: " + response.getId());
        } else {
            req.setAttribute("message", "Error al crear el horario (código " + connection.getResponseCode() + ")");
        }

        connection.disconnect();
        req.getRequestDispatcher("/WEB-INF/views/schedule/form.jsp").forward(req, resp);
    }
}
