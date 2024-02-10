package tw.shop.promotion.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PromotionDto {
    
    private Long promotionId;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal discount;
    private String promotionType;
    
    // Constructors are handled by Lombok @Data
}
