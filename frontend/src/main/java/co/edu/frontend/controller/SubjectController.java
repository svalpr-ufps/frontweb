package co.edu.frontend.controller;

import co.edu.frontend.model.SubjectRequest;
import co.edu.frontend.model.SubjectResponse;
import lombok.RequiredArgsConstructor;
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
    public String showForm(Model model) {
        model.addAttribute("subject", new SubjectRequest());
        return "subject/form";
    }

    @PostMapping("/save")
    public String saveSubject(@ModelAttribute SubjectRequest subject) {
        restTemplate.postForEntity(apiUrl, subject, SubjectResponse.class);
        return "redirect:/subjects";
    }
}
