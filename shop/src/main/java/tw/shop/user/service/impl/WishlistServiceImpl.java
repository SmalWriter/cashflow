package tw.shop.user.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.shop.product.model.Product;
import tw.shop.product.repository.ProductRepository;
import tw.shop.user.dto.WishlistItemDto;
import tw.shop.user.model.User;
import tw.shop.user.model.WishlistItem;
import tw.shop.user.repository.UserRepository;
import tw.shop.user.repository.WishlistItemRepository;
import tw.shop.user.service.WishlistService; 

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WishlistServiceImpl implements WishlistService {

    private final WishlistItemRepository wishlistItemRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public WishlistServiceImpl(WishlistItemRepository wishlistItemRepository, ModelMapper modelMapper, ProductRepository productRepository, UserRepository userRepository) {
        this.wishlistItemRepository = wishlistItemRepository;
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public WishlistItemDto addProductsToWishlist(WishlistItemDto wishlistItemDto) {
        WishlistItem wishlistItem = modelMapper.map(wishlistItemDto, WishlistItem.class);
        User user = userRepository.findById(wishlistItemDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + wishlistItemDto.getUserId()));
        Set<Product> products = new HashSet<>();
        for (Long productId : wishlistItemDto.getProductIds()) {
            Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
            products.add(product);
        }
        wishlistItem.setUser(user);
        wishlistItem.setProducts(products);
        wishlistItem = wishlistItemRepository.save(wishlistItem);
        return modelMapper.map(wishlistItem, WishlistItemDto.class);
    }

    @Override
    public void removeProductsFromWishlist(Long wishlistItemId, Set<Long> productIds) {
        WishlistItem wishlistItem = wishlistItemRepository.findById(wishlistItemId)
                .orElseThrow(() -> new RuntimeException("WishlistItem not found with id: " + wishlistItemId));
        wishlistItem.getProducts().removeIf(product -> productIds.contains(product.getProductId()));
        wishlistItemRepository.save(wishlistItem);
    }

    @Override
    public List<WishlistItemDto> getUserWishlist(Long userId) {
        return wishlistItemRepository.findByUserId(userId).stream()
                .map(item -> modelMapper.map(item, WishlistItemDto.class))
                .collect(Collectors.toList());
    }
}
