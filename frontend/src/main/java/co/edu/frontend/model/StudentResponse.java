package co.edu.frontend.model;

import lombok.Data;

@Data
public class StudentResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String birthDate;
    private String enrollmentDate;
    private String studentCode;
    private String status;
}
