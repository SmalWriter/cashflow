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

	@Column(nullable = false)
	private LocalDateTime updatedAt;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public UserOAuth() {
		super();
	}

	public UserOAuth(Long userOAuthId, User user, String providerName, String providerUserId, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.userOAuthId = userOAuthId;
		this.user = user;
		this.providerName = providerName;
		this.providerUserId = providerUserId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getUserOAuthId() {
		return userOAuthId;
	}

	public void setUserOAuthId(Long userOAuthId) {
		this.userOAuthId = userOAuthId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProviderUserId() {
		return providerUserId;
	}

	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId;
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

	// Getters and Setters

}