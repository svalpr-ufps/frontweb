package co.edu.frontend.controller;

import co.edu.frontend.model.GradeRequest;
import co.edu.frontend.model.GradeResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet("/grades")
public class GradeController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Simulación de lista temporal
    private static List<GradeResponse> grades = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("form".equals(action)) {
            req.getRequestDispatcher("/WEB-INF/views/grade/form.jsp").forward(req, resp);
        } else {
            req.setAttribute("grades", grades);
            req.getRequestDispatcher("/WEB-INF/views/grade/list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GradeRequest request = new GradeRequest();
        request.setStudentCode(req.getParameter("studentCode"));
        request.setSubjectCode(req.getParameter("subjectCode"));
        request.setCourseCode(req.getParameter("courseCode"));
        request.setCourseName(req.getParameter("courseName"));
        request.setPeriod(req.getParameter("period"));
        request.setValue(Double.parseDouble(req.getParameter("value")));
        request.setComments(req.getParameter("comments"));

        // Simulación de respuesta
        GradeResponse response = new GradeResponse();
        response.setId(UUID.randomUUID());
        response.setStudentCode(request.getStudentCode());
        response.setSubjectCode(request.getSubjectCode());
        response.setSubjectName(request.getCourseName());
        response.setPeriod(request.getPeriod());
        response.setValue(request.getValue());
        response.setStatus(request.getValue() >= 3.0 ? "APROBADO" : "REPROBADO");

        grades.add(response);

        resp.sendRedirect("grades");
    }
}
