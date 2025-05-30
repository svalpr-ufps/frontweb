package co.edu.frontend.controller;

import co.edu.frontend.model.ReservationRequest;
import co.edu.frontend.model.ReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final RestTemplate restTemplate;
    private final String apiUrl = "http://localhost:8080/api/reservations";

    @GetMapping
    public String list(Model model) {
        ReservationResponse[] reservations = restTemplate.getForObject(apiUrl + "?userId=USER_ID_AQUI", ReservationResponse[].class);
        model.addAttribute("reservations", Arrays.asList(reservations));
        return "reservation/list";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("reservation", new ReservationRequest());
        return "reservation/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ReservationRequest reservation) {
        UUID userId = UUID.randomUUID(); // Simula el ID del usuario
        restTemplate.postForEntity(apiUrl + "?userId=" + userId, reservation, ReservationResponse.class);
        return "redirect:/reservations";
    }
}
