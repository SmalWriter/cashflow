package tw.shop.cart.service;

import tw.shop.cart.dto.CartItemDto;
import java.util.List;

public interface CartItemService {
    CartItemDto addCartItem(CartItemDto cartItemDto);
    CartItemDto getCartItemById(Long cartItemId);
    List<CartItemDto> getAllCartItemsByCartId(Long cartId);
    CartItemDto updateCartItem(Long cartItemId, CartItemDto cartItemDto);
    void removeCartItem(Long cartItemId);
}
