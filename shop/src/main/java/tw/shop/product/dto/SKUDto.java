package tw.shop.product.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class SKUDto {
    
    private Long id;
    private Long productId;
    private String skuCode;
    private BigDecimal price;
    private Integer stockQuantity;
    private String attributes; // SKU的额外属性
}
