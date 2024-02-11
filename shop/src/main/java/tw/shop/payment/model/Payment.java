package tw.shop.payment.model;

import jakarta.persistence.*;
import tw.shop.cart.model.Cart;
import tw.shop.order.model.Order;
import tw.shop.user.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
@Data
@Entity
@Table(name = "Payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @Column(nullable = false)
    private Long orderId;

    @Column(nullable = false)
    private String paymentMethod;

    @Column(nullable = false)
    private String paymentStatus;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;
    
	public Payment() {
		super();
	}
    // Getters and Setters
}
