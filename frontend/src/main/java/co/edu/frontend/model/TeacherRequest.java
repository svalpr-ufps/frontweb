package co.edu.frontend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String specialization;
}
