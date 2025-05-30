package co.edu.frontend.model;

import lombok.Data;
import java.util.UUID;

@Data
public class MessageRequest {
    private UUID receiverId;
    private String content;
}
