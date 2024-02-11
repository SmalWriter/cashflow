package tw.shop.product.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import tw.shop.cart.model.Cart;
import tw.shop.cart.model.CartItem;
import tw.shop.order.model.OrderItem;
import tw.shop.promotion.model.Promotion;
import tw.shop.user.model.User;
@Data
@Entity
@Table(name = "Products")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String productName;

    private String productDescription;

    @Column(nullable = false)
    private BigDecimal productPrice;
    
    @Column(nullable = false)
    private int stockQuantity;

    private String imageUrl;

    @Column(nullable = false)
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Stock stock;
    
    @OneToMany(mappedBy = "product")
    private Set<CartItem> cartItems = new HashSet<>();
    
    @OneToMany(mappedBy = "product")
    private Set<OrderItem> orderItems = new HashSet<>();
    
    /*
     * 如果你想展示一個產品頁面，並在該頁面上列出「由此產品推薦」的其他產品，
     * 你可以使用 recommendedProducts 集合。
     * 相反，如果你想找到所有「推薦此產品」的來源，
     * 你可以使用 productRecommendations 集合。
     */
    
    //可理解為：此產品推薦了以下產品
    // 此產品推薦的所有產品集合
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<ProductRecommendation> recommendedProducts = new HashSet<>(); // 推薦出去的產品集合

    //可理解為：以下產品推薦了此產品
    // 推薦此產品的所有產品集合
    @OneToMany(mappedBy = "recommendedProduct", fetch = FetchType.LAZY)
    private Set<ProductRecommendation> productRecommendations = new HashSet<>(); // 推薦此產品的產品集合
    
    
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<Review> reviews = new HashSet<>();
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<SKU> skus;
    
    @ManyToMany
    @JoinTable(
      name = "ProductCategory",
      joinColumns = @JoinColumn(name = "productId"),
      inverseJoinColumns = @JoinColumn(name = "categoryId")
    )
    private Set<Category> categories = new HashSet<>();
    
    @ManyToMany(mappedBy = "products")
    private Set<Promotion> promotions = new HashSet<>();

	public Product() {
		super();
	}
    // Getters and Setters
}
	
