package tw.shop.product.service;

import tw.shop.product.dto.SKUDto;
import java.util.List;

public interface SKUService {
    SKUDto createSKU(SKUDto skuDto);
    List<SKUDto> findByProductId(Long productId);
    void updateSKUStock(Long skuId, Integer newStockQuantity); // 更新SKU库存
    // 可以根据需要添加更多方法
}
