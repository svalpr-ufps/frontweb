package co.edu.frontend.controller;

import co.edu.frontend.model.SubjectRequest;
import co.edu.frontend.model.SubjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.UUID;

@Controller
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final RestTemplate restTemplate;
    private final String apiUrl = "http://localhost:8080/api/subjects";

    @GetMapping
    public String listSubjects(Model model) {
        SubjectResponse[] subjects = restTemplate.getForObject(apiUrl, SubjectResponse[].class);
        model.addAttribute("subjects", Arrays.asList(subjects));
        return "subject/list";
    }

    @GetMapping("/form")
    public String showForm(@RequestParam(required = false) UUID id, Model model) {
        if (id != null) {
            SubjectResponse response = restTemplate.getForObject(apiUrl + "/" + id, SubjectResponse.class);
            SubjectRequest request = new SubjectRequest();
            // Copiar datos del response al request
            request.setName(response.getName());
            request.setCredits(response.getCredits());
            request.setCourseId(response.getId());
            model.addAttribute("id", id);
            model.addAttribute("subject", request);
        } else {
            model.addAttribute("subject", new SubjectRequest());
        }
        return "subject/form";
    }

    @PostMapping("/save")
    public String saveSubject(@RequestParam(required = false) UUID id, @ModelAttribute SubjectRequest subject) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SubjectRequest> requestEntity = new HttpEntity<>(subject, headers);

        if (id != null) {
            restTemplate.exchange(apiUrl + "/" + id, HttpMethod.PUT, requestEntity, SubjectResponse.class);
        } else {
            restTemplate.postForEntity(apiUrl, subject, SubjectResponse.class);
        }
        return "redirect:/subjects";
    }

    @GetMapping("/delete")
    public String deleteSubject(@RequestParam UUID id) {
        restTemplate.delete(apiUrl + "/" + id);
        return "redirect:/subjects";
    }

    @GetMapping("/assign")
    public String assignTeacher(@RequestParam UUID subjectId, @RequestParam UUID teacherId) {
        restTemplate.postForEntity(apiUrl + "/" + subjectId + "/assign-teacher/" + teacherId, null, SubjectResponse.class);
        return "redirect:/subjects";
    }

    @GetMapping("/details")
    public String subjectDetails(@RequestParam UUID id, Model model) {
        SubjectResponse subject = restTemplate.getForObject(apiUrl + "/" + id, SubjectResponse.class);
        model.addAttribute("subject", subject);
        return "subject/details";
    }
}
