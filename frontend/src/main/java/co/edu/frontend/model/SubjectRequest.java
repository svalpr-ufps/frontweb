package co.edu.frontend.model;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class SubjectRequest {
    private String code;
    private String name;
    private String schedule;
    private String classroom;
    private Integer capacity;
    private UUID courseId;
    private UUID teacherId;
    private List<UUID> resourceIds;
}
