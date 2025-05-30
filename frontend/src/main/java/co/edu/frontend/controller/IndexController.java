package co.edu.frontend.controller;

import co.edu.frontend.model.LoginResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(HttpSession session, Model model) {
        LoginResponse usuario = (LoginResponse) session.getAttribute("usuario");

        if (usuario != null) {
            model.addAttribute("nombre", usuario.getNombre());
            model.addAttribute("rol", usuario.getRol());
        }

        return "index"; // Mapea a /WEB-INF/views/index.jsp
    }
}
