package tw.shop.promotion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.shop.promotion.dto.PromotionDto;
import tw.shop.promotion.model.Promotion;
import tw.shop.promotion.repository.PromotionRepository;
import tw.shop.promotion.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;

    @Autowired
    public PromotionServiceImpl(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public PromotionDto createPromotion(PromotionDto promotionDto) {
        // Implementation logic here
        // Convert DTO to entity, save it, and return the saved entity converted back to DTO
        return null;
    }
}
