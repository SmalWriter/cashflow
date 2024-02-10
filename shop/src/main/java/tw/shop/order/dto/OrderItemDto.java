package tw.shop.order.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderItemDto {
    private Long orderItemId;
    private Long orderId;
    private Long productId;
    private BigDecimal purchasePrice;
    private int quantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
	public OrderItemDto() {
		super();
	}

	public OrderItemDto(Long orderItemId, Long orderId, Long productId, BigDecimal purchasePrice, int quantity,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.productId = productId;
		this.purchasePrice = purchasePrice;
		this.quantity = quantity;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public Long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

    
    // Constructors, Getters, and Setters
}
