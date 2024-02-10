package tw.shop.product.dto;

import lombok.Data;

@Data
public class ProductRecommendationDto {
    
    private Long recommendationId;
    private Long productId;
    private Long recommendedProductId;

    // Getters and Setters
}
