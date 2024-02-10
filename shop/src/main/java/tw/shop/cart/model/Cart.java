package tw.shop.cart.model;

import jakarta.persistence.*;

import tw.shop.user.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
@Data
@Entity
@Table(name = "Carts")
public class Cart {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    
    public Cart() {
        super();
    }
    // Getters and Setters
}
