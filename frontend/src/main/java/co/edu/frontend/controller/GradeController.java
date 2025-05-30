package co.edu.frontend.controller;

import co.edu.frontend.model.GradeRequest;
import co.edu.frontend.model.GradeResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@WebServlet("/grades")
public class GradeController extends HttpServlet {

    private static final String API_URL = "http://localhost:8081/api/grades";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("form".equals(action)) {
            req.getRequestDispatcher("/WEB-INF/views/grade/form.jsp").forward(req, resp);
        } else {
            String studentId = req.getParameter("studentId");
            if (studentId != null && !studentId.isEmpty()) {
                ResponseEntity<GradeResponse[]> response = restTemplate.getForEntity(
                        API_URL + "/student/" + studentId, GradeResponse[].class);
                List<GradeResponse> grades = Arrays.asList(response.getBody());
                req.setAttribute("grades", grades);
            }
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

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<GradeRequest> entity = new HttpEntity<>(request, headers);
        restTemplate.postForEntity(API_URL, entity, GradeResponse.class);

        resp.sendRedirect("grades?studentId=" + request.getStudentCode());
    }
}
