package tw.shop.user.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    // Constructors, Getters, and Setters
}
