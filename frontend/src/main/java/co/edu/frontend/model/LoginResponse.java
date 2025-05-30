package co.edu.frontend.model;

import lombok.Data;
import java.util.UUID;

@Data
public class LoginResponse {
    private UUID id;
    private String token;
    private String nombre;
    private String rol;
}
