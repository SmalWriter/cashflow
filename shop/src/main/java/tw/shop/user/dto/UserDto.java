package tw.shop.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UserDto {
    
	private Long userId;
    
    @NotNull(message = "Email cannot be null")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Username cannot be null")
    private String username;

    @NotNull(message = "Password cannot be null")
    private String password;
    
    
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
	
	
	public UserDto() {
		super();
	}
	public UserDto(Long userId, String email, String username) {
		super();
		this.userId = userId;
		this.email = email;
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", email=" + email + ", username=" + username + ", password=" + password + "]";
	}
	

	
    
    
}
