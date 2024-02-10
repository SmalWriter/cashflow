package tw.shop.product.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.shop.product.dto.SKUDto;
import tw.shop.product.model.SKU;
import tw.shop.product.repository.SKURepository;
import tw.shop.product.service.SKUService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SKUServiceImpl implements SKUService {

    private final SKURepository skuRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SKUServiceImpl(SKURepository skuRepository, ModelMapper modelMapper) {
        this.skuRepository = skuRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SKUDto createSKU(SKUDto skuDto) {
        SKU sku = modelMapper.map(skuDto, SKU.class);
        sku = skuRepository.save(sku);
        return modelMapper.map(sku, SKUDto.class);
    }

    @Override
    public List<SKUDto> findByProductId(Long productId) {
        return skuRepository.findAll().stream()
        		.filter(sku -> sku.getProduct().getProductId().equals(productId))
                .map(sku -> modelMapper.map(sku, SKUDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void updateSKUStock(Long skuId, Integer newStockQuantity) {
        SKU sku = skuRepository.findById(skuId)
                .orElseThrow(() -> new IllegalArgumentException("SKU not found with id: " + skuId));
        sku.setStockQuantity(newStockQuantity);
        skuRepository.save(sku);
    }
}
