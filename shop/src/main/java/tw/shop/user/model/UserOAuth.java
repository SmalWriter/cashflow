package tw.shop.user.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import tw.shop.cart.model.Cart;

@Data
@Entity
@Table(name = "UserOAuth")
public class UserOAuth {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userOAuthId;

	@Column(nullable = false)
	private String providerName;

	@Column(nullable = false)
	private String providerUserId;

	@Column(nullable = false)
	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	// Getters and Setters

}