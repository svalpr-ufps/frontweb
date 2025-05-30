package co.edu.frontend.model;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MessageResponse {
    private UUID id;
    private String senderName;
    private String receiverName;
    private String content;
    private LocalDateTime sentAt;
    private boolean isRead;
}
