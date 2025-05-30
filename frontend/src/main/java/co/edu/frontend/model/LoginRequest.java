package co.edu.frontend.model;

import lombok.Data;

@Data
public class LoginRequest {
    private String usuario;  // corresponde a "email" en backend
    private String clave;    // corresponde a "password" en backend
}
