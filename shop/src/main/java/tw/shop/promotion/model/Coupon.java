package tw.shop.promotion.model;

import jakarta.persistence.*;
import lombok.Data;
import tw.shop.user.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Coupon")
public class Coupon {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private BigDecimal discount;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;
    private boolean used = false; // 添加used字段，默认为false

    // 优惠券可能指定给特定用户
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    // 省略其他getters和setters

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    // Constructors, Getters, and Setters
}
