package tw.shop.user.model;

import jakarta.persistence.*;
import lombok.Data;
import tw.shop.product.model.Product;

import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "WishlistItem")
public class WishlistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishlistItemId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToMany
    @JoinTable(
        name = "WishlistProduct",
        joinColumns = @JoinColumn(name = "wishlistItemId"),
        inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private Set<Product> products = new HashSet<>();
    // Constructors, Getters, and Setters
}
