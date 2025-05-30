package co.edu.frontend.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class TeacherResponse {
    private UUID id;
    private String teacherCode;
    private String firstName;
    private String lastName;
    private String email;
    private String specialization;
    private LocalDateTime createdAt;
    private List<SubjectSimpleDTO> subjects;

    @Getter
    @Setter
    public static class SubjectSimpleDTO {
        private UUID id;
        private String code;
        private String name;
    }
}
