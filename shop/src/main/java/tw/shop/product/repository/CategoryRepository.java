package tw.shop.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.shop.product.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
