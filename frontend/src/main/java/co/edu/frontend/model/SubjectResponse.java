package co.edu.frontend.model;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class SubjectResponse {
    private UUID id;
    private String code;
    private String name;
    private String schedule;
    private String classroom;
    private Integer capacity;
    private CourseSimpleDTO course;
    private TeacherSimpleDTO teacher;
    private List<AcademicResourceSimpleDTO> resources;

    @Data
    public static class CourseSimpleDTO {
        private UUID id;
        private String code;
        private String name;
    }

    @Data
    public static class TeacherSimpleDTO {
        private UUID id;
        private String firstName;
        private String lastName;
        private String teacherCode;
    }

    @Data
    public static class AcademicResourceSimpleDTO {
        private UUID id;
        private String name;
        private String type;
    }
}
