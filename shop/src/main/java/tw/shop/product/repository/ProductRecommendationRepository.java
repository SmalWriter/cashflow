package tw.shop.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.shop.product.model.ProductRecommendation;

@Repository
public interface ProductRecommendationRepository extends JpaRepository<ProductRecommendation, Long> {
}

