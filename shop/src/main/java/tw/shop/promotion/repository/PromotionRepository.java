package tw.shop.promotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.shop.promotion.model.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    // Additional query methods can be defined here
}
