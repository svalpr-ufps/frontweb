package co.edu.frontend.controller;

import co.edu.frontend.model.StudentRequest;
import co.edu.frontend.model.StudentResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.UUID;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final String API_URL = "http://localhost:8081/api/student";
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public String listarEstudiantes(Model model, HttpSession session) {
        ResponseEntity<StudentResponse[]> response = restTemplate.getForEntity(API_URL, StudentResponse[].class);
        model.addAttribute("lista", Arrays.asList(response.getBody()));
        return "students/list";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("student", new StudentRequest());
        return "students/form";
    }

    @PostMapping("/guardar")
    public String guardarEstudiante(@ModelAttribute StudentRequest student) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<StudentRequest> request = new HttpEntity<>(student, headers);

        restTemplate.postForEntity(API_URL, request, Void.class);
        return "redirect:/students";
    }

    @GetMapping("/editar/{code}")
    public String mostrarFormularioEditar(@PathVariable String code, Model model) {
        StudentResponse student = restTemplate.getForObject(API_URL + "/code/" + code, StudentResponse.class);
        StudentRequest req = new StudentRequest();
        req.setFirstName(student.getFirstName());
        req.setLastName(student.getLastName());
        req.setEmail(student.getEmail());
        req.setPhone(student.getPhone());
        req.setBirthDate(student.getBirthDate());
        req.setStudentCode(student.getStudentCode());
        req.setEnrollmentDate(student.getEnrollmentDate());
        model.addAttribute("student", req);
        return "students/form";
    }

    @GetMapping("/eliminar/{code}")
    public String eliminarEstudiante(@PathVariable String code) {
        restTemplate.delete(API_URL + "/code/" + code);
        return "redirect:/students";
    }

    @GetMapping("/ver/{code}")
    public String verDetalles(@PathVariable String code, Model model) {
        StudentResponse student = restTemplate.getForObject(API_URL + "/code/" + code, StudentResponse.class);
        model.addAttribute("student", student);
        return "students/form";
    }
}
