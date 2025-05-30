package co.edu.frontend.model;

import lombok.Data;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class ScheduleRequest {
    private UUID courseId;
    private UUID roomId;
    private DayOfWeek day;
    private LocalTime startTime;
    private LocalTime endTime;
}
