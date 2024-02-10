package tw.shop.product.service;

import tw.shop.product.dto.ReviewDto;
import java.util.List;

public interface ReviewService {
    ReviewDto createReview(ReviewDto reviewDto);
    List<ReviewDto> findByProductId(Long productId);
    // Additional methods as needed
}
