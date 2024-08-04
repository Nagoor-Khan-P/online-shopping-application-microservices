package com.nagoorkhan.inventoryservice.service;

import com.nagoorkhan.inventoryservice.model.InventoryVO;
import com.nagoorkhan.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryVO> getProductsStock(List<String> skuCodes) {
        return inventoryRepository.findBySkuCodeIn(skuCodes);
    }
}
