package co.edu.frontend.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ReservationRequest {
    private UUID roomId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private UUID subjectId;
    private String purpose;
}

