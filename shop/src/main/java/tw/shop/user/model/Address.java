package tw.shop.user.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String fullAddress;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    // Constructors, Getters, and Setters
}
