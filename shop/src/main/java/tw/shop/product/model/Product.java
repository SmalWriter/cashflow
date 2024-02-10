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
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    private String description;

    @Column(nullable = false)
    private int stockQuantity;

    private String imageUrl;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;
    
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Stock stock;
    
    @OneToMany(mappedBy = "product")
    private Set<CartItem> cartItems = new HashSet<>();
    
    @OneToMany(mappedBy = "product")
    private Set<OrderItem> orderItems = new HashSet<>();
    
    /*
     * 如果你想展示一個產品頁面，並在該頁面上列出「由此產品推薦」的其他產品，
     * 你可以使用 recommendedProducts 集合。相反，如果你想找到所有「推薦此產品」的來源，
     * 你可以使用 productRecommendations 集合。
     */
    
    //可理解為：此產品推薦了以下產品
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<ProductRecommendation> recommendedProducts = new HashSet<>();

    //可理解為：以下產品推薦了此產品
    @OneToMany(mappedBy = "recommendedProduct", fetch = FetchType.LAZY)
    private Set<ProductRecommendation> productRecommendations = new HashSet<>();
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<Review> reviews = new HashSet<>();
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<SKU> skus;
    
    @ManyToMany
    @JoinTable(
      name = "product_category",
      joinColumns = @JoinColumn(name = "productId"),
      inverseJoinColumns = @JoinColumn(name = "categoryId")
    )
    private Set<Category> categories = new HashSet<>();
    
    @ManyToMany(mappedBy = "products")
    private Set<Promotion> promotions = new HashSet<>();

	public Product() {
		super();
	}

	public Product(Long productId, String name, BigDecimal price, String description, int stockQuantity,
			String imageUrl, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.stockQuantity = stockQuantity;
		this.imageUrl = imageUrl;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

    // Getters and Setters
}
	
