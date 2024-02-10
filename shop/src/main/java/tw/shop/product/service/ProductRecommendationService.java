package tw.shop.product.service;

import tw.shop.product.dto.ProductRecommendationDto;

public interface ProductRecommendationService {
    ProductRecommendationDto createRecommendation(ProductRecommendationDto recommendationDto);
    // Additional methods can be added as needed
}
