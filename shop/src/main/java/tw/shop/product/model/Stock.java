package tw.shop.product.model;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId;

    private Integer quantity; // 库存数量

    private Integer reservedQuantity; // 库存预留

    private String stockLocation; // 库存位置

    private String batchNo; // 库存批次

    private String stockStatus; // 库存状态

    private BigDecimal stockCost; // 库存成本

    private BigDecimal stockValue; // 库存价值

    @OneToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    private Product product; // 关联的产品

    // Constructors, Getters, and Setters
}
