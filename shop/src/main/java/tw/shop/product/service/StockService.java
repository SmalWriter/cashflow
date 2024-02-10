package tw.shop.product.service;

import tw.shop.product.dto.StockDto;

public interface StockService {
    StockDto updateStock(StockDto stockDto); // 更新库存信息
    StockDto getStockByProductId(Long productId); // 根据产品ID获取库存信息
    // Additional methods as needed
}
