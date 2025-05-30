package co.edu.frontend.controller;

import co.edu.frontend.model.LoginRequest;
import co.edu.frontend.model.LoginResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
public class LoginController {

    private final String AUTH_URL = "http://localhost:8081/api/auth/login";

    @GetMapping("/")
    public String home(HttpSession session) {
        if (session.getAttribute("usuario") != null) {
            return "redirect:/dashboard";
        }
        return "redirect:/login";
    }


    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(
            @RequestParam String usuario,
            @RequestParam String clave,
            HttpSession session,
            Model model) {

        RestTemplate restTemplate = new RestTemplate();

        // Backend espera 'email' y 'password'
        var json = """
                {
                    "email": "%s",
                    "password": "%s"
                }
                """.formatted(usuario, clave);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

        try {
            ResponseEntity<LoginResponse> response = restTemplate.exchange(
                    AUTH_URL,
                    HttpMethod.POST,
                    requestEntity,
                    LoginResponse.class
            );

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                LoginResponse user = response.getBody();
                user.setNombre(usuario); // Añadir datos manuales si backend no devuelve
                user.setRol("ESTUDIANTE");
                session.setAttribute("usuario", user);
                return "redirect:/dashboard";
            }

        } catch (Exception e) {
            model.addAttribute("error", "Credenciales inválidas o servidor no disponible");
        }

        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        LoginResponse user = (LoginResponse) session.getAttribute("usuario");
        if (user == null) return "redirect:/login";
        model.addAttribute("usuario", user.getNombre());
        model.addAttribute("rol", user.getRol());
        return "dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
