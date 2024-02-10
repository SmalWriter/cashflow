package tw.shop.product.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.shop.product.dto.StockDto;
import tw.shop.product.model.Stock;
import tw.shop.product.repository.StockRepository;
import tw.shop.product.service.StockService;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository, ModelMapper modelMapper) {
        this.stockRepository = stockRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StockDto updateStock(StockDto stockDto) {
        Stock stock = stockRepository.findById(stockDto.getProductId())
                .orElseThrow(() -> new RuntimeException("Stock not found for product id: " + stockDto.getProductId()));
        modelMapper.map(stockDto, stock);
        stock = stockRepository.save(stock);
        return modelMapper.map(stock, StockDto.class);
    }

    @Override
    public StockDto getStockByProductId(Long productId) {
        Stock stock = stockRepository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Stock not found for product id: " + productId));
        return modelMapper.map(stock, StockDto.class);
    }
}

