package co.edu.frontend.controller;

import co.edu.frontend.model.ReservationRequest;
import co.edu.frontend.model.ReservationResponse;
import co.edu.frontend.model.RoomType;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final RestTemplate restTemplate;
    private final String backendUrl = "http://localhost:8080/api/reservations";

    // Para pruebas: ID de usuario fijo
    private final UUID userId = UUID.fromString("11111111-1111-1111-1111-111111111111");

    // Listar reservas del usuario
    @GetMapping
    public String list(Model model) {
        ReservationResponse[] reservations = restTemplate.getForObject(
                backendUrl + "?userId=" + userId,
                ReservationResponse[].class
        );
        model.addAttribute("reservations", Arrays.asList(reservations));
        return "reservation/list";
    }

    // Mostrar formulario de nueva reserva
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("reservation", new ReservationRequest());
        return "reservation/form";
    }

    // Guardar reserva
    @PostMapping("/save")
    public String save(@ModelAttribute ReservationRequest reservation) {
        restTemplate.postForEntity(
                backendUrl,
                new org.springframework.http.HttpEntity<>(reservation, buildUserHeader()),
                ReservationResponse.class
        );
        return "redirect:/reservations";
    }

    // Consultar habitaciones disponibles
    @GetMapping("/available")
    public String availableRooms(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            @RequestParam(required = false) RoomType type,
            Model model
    ) {
        String url = backendUrl + "/available-rooms?startDate=" + startDate + "&endDate=" + endDate;
        if (type != null) url += "&type=" + type;

        Object[] rooms = restTemplate.getForObject(url, Object[].class);
        model.addAttribute("rooms", rooms);
        return "reservation/available";
    }

    // Cabecera con el ID del usuario
    private org.springframework.http.HttpHeaders buildUserHeader() {
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.set("X-User-Id", userId.toString());
        return headers;
    }
}
