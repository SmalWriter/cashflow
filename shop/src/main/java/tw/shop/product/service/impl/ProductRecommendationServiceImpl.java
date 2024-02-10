package tw.shop.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.shop.product.dto.ProductRecommendationDto;
import tw.shop.product.model.ProductRecommendation;
import tw.shop.product.repository.ProductRecommendationRepository;
import tw.shop.product.service.ProductRecommendationService;

@Service
public class ProductRecommendationServiceImpl implements ProductRecommendationService {

    private final ProductRecommendationRepository recommendationRepository;

    @Autowired
    public ProductRecommendationServiceImpl(ProductRecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public ProductRecommendationDto createRecommendation(ProductRecommendationDto recommendationDto) {
        // Implementation logic here
        // Convert DTO to entity, save it, and return the saved entity converted back to DTO
        return null;
    }
}
