package co.edu.frontend.model;

import lombok.Data;

import java.util.UUID;

@Data
public class GradeResponse {
    private UUID id;
    private String studentCode;
    private String subjectCode;
    private String subjectName;
    private String period;
    private double value;
    private String status;
}
