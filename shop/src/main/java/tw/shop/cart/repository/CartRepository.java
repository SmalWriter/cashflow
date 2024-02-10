package tw.shop.cart.repository;

import tw.shop.cart.model.Cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    // Custom methods can be added here
	
	//這個方法會返回一個List<Cart>，包含了指定用戶的所有購物車（儘管在很多場景中，用戶可能只有一個購物車）。
	//使用這種方法，您可以很容易地根據用戶ID獲取到其所有的購物車信息。
	//但我們實際設好了直接關聯關係，可能不用這個方法了。
	List<Cart> findByUserId(Long userId);
}
