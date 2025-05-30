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

@Controller
@RequestMapping("/students")
public class StudentController {

    private final String API_URL = "http://localhost:8081/api/students";
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping
    public String listarEstudiantes(Model model, HttpSession session) {
        ResponseEntity<StudentResponse[]> response = restTemplate.getForEntity(API_URL + "/status/ACTIVE", StudentResponse[].class);
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

        restTemplate.postForEntity(API_URL + "/register", request, StudentResponse.class);
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
        req.setEnrollmentDate(student.getEnrollmentDate());
        req.setStudentCode(student.getStudentCode());

        model.addAttribute("student", req);
        model.addAttribute("studentCode", code);
        return "students/form";
    }

    @PostMapping("/actualizar/{code}")
    public String actualizar(@PathVariable String code, @ModelAttribute StudentRequest student) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<StudentRequest> request = new HttpEntity<>(student, headers);
        restTemplate.exchange(API_URL + "/" + code, HttpMethod.PUT, request, StudentResponse.class);
        return "redirect:/students";
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
        return "students/details";
    }
}
