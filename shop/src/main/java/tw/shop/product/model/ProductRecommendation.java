package tw.shop.product.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="ProductRecommendation")
public class ProductRecommendation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recommendationId;

    /*
     * 如果你想展示一個產品頁面，並在該頁面上列出「由此產品推薦」的其他產品，
     * 你可以使用 recommendedProducts 集合。相反，如果你想找到所有「推薦此產品」的來源，
     * 你可以使用 productRecommendations 集合。
     */
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recommendedProductId")
    private Product recommendedProduct;

    // Getters and Setters
}
