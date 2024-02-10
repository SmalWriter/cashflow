package tw.shop.cart.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.shop.cart.dto.CartDto;
import tw.shop.cart.model.Cart;
import tw.shop.cart.repository.CartRepository;
import tw.shop.cart.service.CartService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CartDto createCart(CartDto cartDto) {
        Cart cart = modelMapper.map(cartDto, Cart.class);
        cart = cartRepository.save(cart);
        return modelMapper.map(cart, CartDto.class);
    }

    @Override
    public CartDto getCartById(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        return modelMapper.map(cart, CartDto.class);
    }

    @Override
    public List<CartDto> getAllCarts() {
        return cartRepository.findAll().stream()
                .map(cart -> modelMapper.map(cart, CartDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CartDto updateCart(Long cartId, CartDto cartDto) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
        modelMapper.map(cartDto, cart);
        cart = cartRepository.save(cart);
        return modelMapper.map(cart, CartDto.class);
    }

    @Override
    public void deleteCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
