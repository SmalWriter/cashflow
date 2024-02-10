package tw.shop.promotion.service;

import tw.shop.promotion.dto.CouponDto;

public interface CouponService {
    CouponDto createCoupon(CouponDto couponDto);
    CouponDto applyCoupon(String code, Long userId);
    // Additional methods as needed
}
