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
    private Long id;

    private Integer quantity; // 库存数量

    private Integer reservedQuantity; // 库存预留

    private String location; // 库存位置

    private String batchNo; // 库存批次

    private String status; // 库存状态

    private BigDecimal cost; // 库存成本

    private BigDecimal value; // 库存价值

    @OneToOne
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private Product product; // 关联的产品

    // Constructors, Getters, and Setters
}
