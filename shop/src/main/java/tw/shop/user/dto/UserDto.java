package tw.shop.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class UserDto {
    
	private Long id;
    
    @NotNull(message = "Email cannot be null")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Username cannot be null")
    private String username;

    @NotNull(message = "Password cannot be null")
    private String password;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public UserDto(Long id, String email, String username) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password + "]";
	}
	

	
    
    
}
