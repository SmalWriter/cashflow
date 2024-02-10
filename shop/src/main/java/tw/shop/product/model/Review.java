package tw.shop.product.model;

import jakarta.persistence.*;
import lombok.Data;
import tw.shop.user.model.User;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content; // 评论内容
    private Integer rating; // 评分，假设1到5

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user; // 评论的用户

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private Product product; // 被评论的产品

    private LocalDateTime createdTime; // 评论创建时间

    // Constructors, Getters, and Setters
}
