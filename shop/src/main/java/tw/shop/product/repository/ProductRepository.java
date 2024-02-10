package tw.shop.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.shop.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // 这里可以根据需求添加自定义的数据库操作方法
}
