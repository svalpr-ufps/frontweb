package co.edu.frontend.model;

import lombok.Data;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class ScheduleResponse {
    private UUID id;
    private UUID courseId;
    private UUID roomId;
    private DayOfWeek day;
    private LocalTime startTime;
    private LocalTime endTime;
}
