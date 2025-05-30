package co.edu.frontend.model;

import lombok.Data;

@Data
public class GradeRequest {
    private String studentCode;
    private String subjectCode;
    private String courseCode;
    private String courseName;
    private String period;
    private Double value;
    private String comments;
}
