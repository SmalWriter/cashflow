package tw.shop.social.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;
import tw.shop.user.model.User;

@Data
@Entity
@Table(name="Follow")
public class Follow {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followerId")
    private User follower; // 关注者

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followingId")
    private User following; // 被关注者

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now(); // 关注时间
}
