package tw.shop.promotion.service.impl;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.shop.promotion.dto.CouponDto;
import tw.shop.promotion.model.Coupon;
import tw.shop.promotion.repository.CouponRepository;
import tw.shop.promotion.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CouponServiceImpl(CouponRepository couponRepository, ModelMapper modelMapper) {
        this.couponRepository = couponRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CouponDto createCoupon(CouponDto couponDto) {
        Coupon coupon = modelMapper.map(couponDto, Coupon.class);
        coupon = couponRepository.save(coupon);
        return modelMapper.map(coupon, CouponDto.class);
    }

    @Override
    public CouponDto applyCoupon(String code, Long userId) {
        Coupon coupon = couponRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Coupon with code: " + code + " not found."));

        LocalDateTime now = LocalDateTime.now();
        if (coupon.isUsed() || now.isBefore(coupon.getValidFrom()) || now.isAfter(coupon.getValidTo())) {
            throw new RuntimeException("Coupon is either not valid or has already been used.");
        }

        if (coupon.getUser() != null && !coupon.getUser().getUserId().equals(userId)) {
            throw new RuntimeException("Coupon is not valid for this user.");
        }

        coupon.setUsed(true);
        couponRepository.save(coupon);

        // 返回优惠券DTO，这里简化处理
        return new CouponDto(
        	    coupon.getCouponId(), 
        	    coupon.getCouponCode(), 
        	    coupon.getDiscount(), 
        	    coupon.getValidFrom(), 
        	    coupon.getValidTo(), 
        	    (coupon.getUser() != null ? coupon.getUser().getUserId() : null), // 用户ID，如果优惠券没有指定用户，则可能为null
        	    coupon.isUsed() // 传递优惠券的使用状态
        	);}
}
