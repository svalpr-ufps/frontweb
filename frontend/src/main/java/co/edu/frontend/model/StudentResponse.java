package co.edu.frontend.model;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class StudentResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String status;
    private String studentCode;
    private LocalDate enrollmentDate;
    private String roleName;
}
