package tw.shop.product.service;

import tw.shop.product.dto.CategoryDto;
import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    List<CategoryDto> getAllCategories();
    // Additional methods as needed
}
