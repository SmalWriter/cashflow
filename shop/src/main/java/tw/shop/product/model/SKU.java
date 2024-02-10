package tw.shop.product.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="SKU")
public class SKU {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    private String skuCode;
    private BigDecimal price;
    private Integer stockQuantity;
    private String attributes; // JSON格式的字符串，存储SKU的额外属性，如颜色、尺寸等。

    // Constructors, Getters, and Setters are handled by Lombok @Data
}
