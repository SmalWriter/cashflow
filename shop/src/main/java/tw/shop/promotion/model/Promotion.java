package tw.shop.promotion.model;

import jakarta.persistence.*;
import lombok.Data;
import tw.shop.product.model.Category;
import tw.shop.product.model.Product;
import tw.shop.user.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="Promotion")
public class Promotion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long promotionId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    private BigDecimal discount;

    @Column(nullable = false)
    private String promotionType;
    
    @ManyToMany
    @JoinTable(
        name = "promotion_product",
        joinColumns = @JoinColumn(name = "promotionId"),
        inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private Set<Product> products = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "promotion_user",
        joinColumns = @JoinColumn(name = "promotionId"),
        inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private Set<User> users = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "promotion_category",
        joinColumns = @JoinColumn(name = "promotionId"),
        inverseJoinColumns = @JoinColumn(name = "categoryId")
    )
    private Set<Category> categories = new HashSet<>();
    
    // Constructors, Getters, and Setters are handled by Lombok @Data
}
