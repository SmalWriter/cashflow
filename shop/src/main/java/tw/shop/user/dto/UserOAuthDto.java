package tw.shop.user.dto;

public class UserOAuthDto {
	private Long userOAuthId;
	private Long userId;
	private String providerName;
	private String providerUserId;

	// Constructors
	public UserOAuthDto() {
	}

	public UserOAuthDto(Long userOAuthId, Long userId, String providerName, String providerUserId) {
		this.userOAuthId = userOAuthId;
		this.userId = userId;
		this.providerName = providerName;
		this.providerUserId = providerUserId;
	}

	// Getters and Setters
	public Long getUserOAuthId() {
		return userOAuthId;
	}

	public void setUserOAuthId(Long userOAuthId) {
		this.userOAuthId = userOAuthId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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
}
