package co.edu.frontend.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ReservationResponse {
    private UUID id;
    private String roomCode;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String purpose;
    private String status;
}
