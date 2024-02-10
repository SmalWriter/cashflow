package tw.shop.promotion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.shop.promotion.model.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    // 可以添加根据code或userId查找Coupon的方法
    Optional<Coupon> findByCode(String code);

}
