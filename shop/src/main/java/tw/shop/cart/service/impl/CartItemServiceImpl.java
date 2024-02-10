package tw.shop.cart.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.shop.cart.dto.CartItemDto;
import tw.shop.cart.model.Cart;
import tw.shop.cart.model.CartItem;
import tw.shop.cart.repository.CartItemRepository;
import tw.shop.cart.repository.CartRepository;
import tw.shop.cart.service.CartItemService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository, CartRepository cartRepository, ModelMapper modelMapper) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CartItemDto addCartItem(CartItemDto cartItemDto) {
        Cart cart = cartRepository.findById(cartItemDto.getCartId())
                .orElseThrow(() -> new RuntimeException("Cart not found with id: " + cartItemDto.getCartId()));
        CartItem cartItem = modelMapper.map(cartItemDto, CartItem.class);
        cartItem.setCart(cart);
        cartItem = cartItemRepository.save(cartItem);
        return modelMapper.map(cartItem, CartItemDto.class);
    }

    @Override
    public CartItemDto getCartItemById(Long cartItemId) {
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("CartItem not found with id: " + cartItemId));
        return modelMapper.map(cartItem, CartItemDto.class);
    }

    @Override
    public List<CartItemDto> getAllCartItemsByCartId(Long cartId) {
        List<CartItem> cartItems = cartItemRepository.findAll().stream()
                .filter(item -> item.getCart().getCartId().equals(cartId))
                .collect(Collectors.toList());
        return cartItems.stream()
                .map(item -> modelMapper.map(item, CartItemDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CartItemDto updateCartItem(Long cartItemId, CartItemDto cartItemDto) {
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("CartItem not found with id: " + cartItemId));
        modelMapper.map(cartItemDto, cartItem);
        cartItem = cartItemRepository.save(cartItem);
        return modelMapper.map(cartItem, CartItemDto.class);
    }

    @Override
    public void removeCartItem(Long cartItemId) {
        if (!cartItemRepository.existsById(cartItemId)) {
            throw new RuntimeException("CartItem not found with id: " + cartItemId);
        }
        cartItemRepository.deleteById(cartItemId);
    }
}
