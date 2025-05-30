package co.edu.frontend.model;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class StudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate birthDate;
    private String password;
    private UUID roleId;
    private String studentCode;
    private LocalDate enrollmentDate;
}
