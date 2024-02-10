package tw.shop.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tw.shop.product.model.SKU;

@Repository
public interface SKURepository extends JpaRepository<SKU, Long> {
    // 这里可以添加查找特定产品SKU的方法
}
