package co.edu.frontend.model;

import lombok.Data;

import java.util.UUID;
import java.util.List;

@Data
public class TeacherResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String specialization;
    private String teacherCode;
    private List<String> subjects; // solo si el backend lo retorna así
}
