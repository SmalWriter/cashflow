package tw.shop.product.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class StockDto {
    private Long id;
    private Integer quantity;
    private Integer reservedQuantity;
    private String location;
    private String batchNo;
    private String status;
    private BigDecimal cost;
    private BigDecimal value;
    private Long productId; // 关联的产品ID
    
	public StockDto(Long id, Integer quantity, Integer reservedQuantity, String location, String batchNo, String status,
			BigDecimal cost, BigDecimal value, Long productId) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.reservedQuantity = reservedQuantity;
		this.location = location;
		this.batchNo = batchNo;
		this.status = status;
		this.cost = cost;
		this.value = value;
		this.productId = productId;
	}

    
    // Constructors, Getters, and Setters
}
