package tw.shop.user.dto;

import lombok.Data;

@Data
public class AddressDto {
    private Long id;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private Long userId;
    
	public AddressDto(Long id, String street, String city, String state, String zipCode, Long userId) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.userId = userId;
	}
    
    
    // Constructors, Getters, and Setters
}
