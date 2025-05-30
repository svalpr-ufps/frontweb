package co.edu.frontend.model;

import lombok.Data;

@Data
public class TeacherRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String specialization;
}
