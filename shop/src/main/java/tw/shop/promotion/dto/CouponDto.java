package tw.shop.promotion.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CouponDto {
	private Long id;
	private String code;
	private BigDecimal discount;
	private LocalDateTime validFrom;
	private LocalDateTime validTo;
	private Long userId; // 可能为null，如果优惠券不指定给特定用户
	private boolean used; // 反映优惠券是否已被使用


	// 请确保有针对所有属性的构造函数或相应的setter方法
	public CouponDto(Long id, String code, BigDecimal discount, LocalDateTime validFrom, LocalDateTime validTo,
			Long userId, boolean used) {
		this.id = id;
		this.code = code;
		this.discount = discount;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.userId = userId;
		this.used = used;
	}

	// Constructors, Getters, and Setters
}
