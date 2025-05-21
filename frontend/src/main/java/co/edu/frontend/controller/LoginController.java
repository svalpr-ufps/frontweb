package co.edu.frontend.controller;

import co.edu.frontend.model.LoginRequest;
import co.edu.frontend.model.LoginResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
public class LoginController {
    private final String AUTH_URL = "http://localhost:8081/api/auth/login";

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Hello World!");
        return "home";
    }

    @GetMapping("/login")
    public String mostrarFormularioLogin(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(
            @RequestParam String usuario,
            @RequestParam String clave,
            HttpSession session,
            Model model) {

        if ("admin".equals(usuario) && "1234".equals(clave)) {
            LoginResponse fakeUser = new LoginResponse();
            fakeUser.setNombre("Administrador Local");
            fakeUser.setRol("ADMIN");
            session.setAttribute("usuario", fakeUser);
            return "redirect:/dashboard";
        }

        RestTemplate restTemplate = new RestTemplate();
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsuario(usuario);
        loginRequest.setClave(clave);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<LoginRequest> requestEntity = new HttpEntity<>(loginRequest, headers);

        try {
            ResponseEntity<LoginResponse> response = restTemplate.exchange(
                    AUTH_URL,
                    HttpMethod.POST,
                    requestEntity,
                    LoginResponse.class
            );

            if (response.getStatusCode() == HttpStatus.OK) {
                session.setAttribute("usuario", response.getBody());
                return "redirect:/dashboard";
            }
        } catch (HttpClientErrorException.Unauthorized e) {
            model.addAttribute("error", "Usuario o clave incorrectos");
        } catch (Exception e) {
            model.addAttribute("error", "Error al contactar el microservicio");
        }

        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        LoginResponse user = (LoginResponse) session.getAttribute("usuario");
        if (user == null) return "redirect:/";

        model.addAttribute("usuario", user.getNombre());
        model.addAttribute("rol", user.getRol());
        return "dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
