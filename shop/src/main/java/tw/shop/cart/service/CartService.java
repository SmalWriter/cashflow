package tw.shop.cart.service;

import tw.shop.cart.dto.CartDto;
import java.util.List;

public interface CartService {
    CartDto createCart(CartDto cartDto);
    CartDto getCartById(Long cartId);
    List<CartDto> getAllCarts();
    CartDto updateCart(Long cartId, CartDto cartDto);
    void deleteCart(Long cartId);
}
