package tw.shop.user.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="UserActivityLog")
public class UserActivityLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;

    @Column(nullable = false)
    private String activityType;

    @Column(nullable = false)
    private LocalDateTime activityDate;

    private String description;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;


    // Constructors, Getters, and Setters are handled by Lombok @Data
}
