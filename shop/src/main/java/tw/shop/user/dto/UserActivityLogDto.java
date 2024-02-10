package tw.shop.user.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserActivityLogDto {
    
    private Long logId;
    private Long userId;
    private String activityType;
    private LocalDateTime activityDate;
    private String description;
    
    // Constructors are handled by Lombok @Data
}
