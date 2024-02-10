package tw.shop.product.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReviewDto {
    private Long id;
    private String content;
    private Integer rating;
    private Long userId;
    private Long productId;
    private LocalDateTime createdTime;

    // Constructors, Getters, and Setters
}
