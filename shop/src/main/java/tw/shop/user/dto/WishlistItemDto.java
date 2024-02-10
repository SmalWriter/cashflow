package tw.shop.user.dto;

import java.util.Set;
import lombok.Data;

@Data
public class WishlistItemDto {
    private Long id;
    private Long userId;
    private Set<Long> productIds;

    // Constructors, Getters, and Setters
}
