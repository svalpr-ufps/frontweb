package co.edu.frontend.controller;

import co.edu.frontend.model.TeacherRequest;
import co.edu.frontend.model.TeacherResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.UUID;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final String API_BASE = "http://localhost:8081/api/teachers";

    @GetMapping
    public String listar(Model model, HttpSession session) {
        RestTemplate rest = new RestTemplate();
        ResponseEntity<TeacherResponse[]> response = rest.getForEntity(API_BASE + "/specialization/ALL", TeacherResponse[].class);
        model.addAttribute("teachers", Arrays.asList(response.getBody()));
        return "teacher/list";
    }

    @GetMapping("/create")
    public String crearForm(Model model) {
        model.addAttribute("teacher", new TeacherRequest());
        return "teacher/form";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute TeacherRequest teacher) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TeacherRequest> request = new HttpEntity<>(teacher, headers);
        rest.postForEntity(API_BASE + "/register", request, TeacherResponse.class);
        return "redirect:/teachers";
    }

    @GetMapping("/edit/{id}")
    public String editarForm(@PathVariable UUID id, Model model) {
        RestTemplate rest = new RestTemplate();
        TeacherResponse teacher = rest.getForObject(API_BASE + "/" + id, TeacherResponse.class);

        TeacherRequest request = new TeacherRequest();
        request.setFirstName(teacher.getFirstName());
        request.setLastName(teacher.getLastName());
        request.setEmail(teacher.getEmail());
        request.setSpecialization(teacher.getSpecialization());

        model.addAttribute("teacherId", id);
        model.addAttribute("teacher", request);
        return "teacher/form";
    }

    @PostMapping("/update/{id}")
    public String actualizar(@PathVariable UUID id, @ModelAttribute TeacherRequest teacher) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TeacherRequest> request = new HttpEntity<>(teacher, headers);
        rest.exchange(API_BASE + "/" + id, HttpMethod.PUT, request, TeacherResponse.class);
        return "redirect:/teachers";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable UUID id) {
        RestTemplate rest = new RestTemplate();
        rest.delete(API_BASE + "/" + id);
        return "redirect:/teachers";
    }

    @GetMapping("/view/{id}")
    public String verDetalles(@PathVariable UUID id, Model model) {
        RestTemplate rest = new RestTemplate();
        TeacherResponse teacher = rest.getForObject(API_BASE + "/" + id, TeacherResponse.class);
        model.addAttribute("teacher", teacher);
        return "teacher/details";
    }
    @PostMapping("/{teacherId}/assign-subject")
    public String asignarMateria(@PathVariable UUID teacherId, @RequestParam UUID subjectId) {
        RestTemplate rest = new RestTemplate();
        rest.postForEntity(API_BASE + "/" + teacherId + "/assign-subject/" + subjectId, null, TeacherResponse.class);
        return "redirect:/teachers/view/" + teacherId;
    }

}
