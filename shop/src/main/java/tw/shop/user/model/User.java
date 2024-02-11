package tw.shop.user.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import tw.shop.cart.model.Cart;
import tw.shop.order.model.Order;
import tw.shop.product.model.Review;
import tw.shop.promotion.model.Coupon;
import tw.shop.promotion.model.Promotion;
import tw.shop.social.model.Follow;
import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();
    
    //解釋：一個使用者可以建立多個訂單，每個訂單記錄使用者在不同時間購買的商品。
    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();
    
    //解釋：一個使用者可以有多種第三方登入方式，例如，一個使用者可能既有 Google 帳號登入，也有 Facebook 帳號登入。
    @OneToMany(mappedBy = "user")
    private Set<UserOAuth> userOAuths = new HashSet<>();
    
    @OneToMany(mappedBy = "user")
    private List<Cart> carts = new ArrayList<>();
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Coupon> coupons = new HashSet<>();
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Address> addresses = new HashSet<>();
    
    @OneToMany(mappedBy = "user")
    private Set<WishlistItem> wishlistItems = new HashSet<>();
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserActivityLog> activityLogs = new HashSet<>();
    
    //在中文中，follower 通常翻譯為「追隨者」，following 通常翻譯為「關注者」。
    
    @OneToMany(mappedBy = "following")
    private Set<Follow> followers = new HashSet<>(); // 关注该用户的人
    
    @OneToMany(mappedBy = "follower")
    private Set<Follow> followings = new HashSet<>(); // 用户正在关注的人

    @ManyToMany(mappedBy = "users")
    private Set<Promotion> promotions = new HashSet<>();
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Review> reviews = new HashSet<>();
    
}
