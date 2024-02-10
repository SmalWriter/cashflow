package tw.shop.user.service;

import tw.shop.user.dto.WishlistItemDto;
import java.util.List;
import java.util.Set;

public interface WishlistService {
    WishlistItemDto addProductsToWishlist(WishlistItemDto wishlistItemDto);
    void removeProductsFromWishlist(Long wishlistItemId, Set<Long> productIds);
    List<WishlistItemDto> getUserWishlist(Long userId);
}
