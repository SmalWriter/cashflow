package tw.shop.social.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class FollowDto {
    
    private Long id;
    private Long followerId;
    private Long followingId;
    private LocalDateTime createdAt;
}
