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
    
    /*
     * 當展示一個產品頁面時，你可能想顯示出「由此產品推薦的其他產品」，
     * 這時你會查詢該產品作為「推薦者」（productId）的所有ProductRecommendation記錄，
     * 以獲得所有被推薦的產品（recommendedProduct）。
     * 相反，如果你想了解「哪些產品推薦了此產品」，
     * 你會查詢該產品作為「被推薦者」（recommendedProductId）的所有ProductRecommendation記錄，
     * 以找出所有推薦它的產品（product）。
     */
    
    // 指向推薦此產品的產品，即此產品是「推薦者」
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private Product product; // 這裡的product是推薦其他產品的產品

    // 指向被推薦的產品，即此產品是「被推薦者」
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recommendedProductId")
    private Product recommendedProduct; // 這裡的recommendedProduct是被推薦的產品

    // Getters and Setters
}
