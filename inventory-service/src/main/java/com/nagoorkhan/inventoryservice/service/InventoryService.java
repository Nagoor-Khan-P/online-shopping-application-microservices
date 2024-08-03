package com.nagoorkhan.inventoryservice.service;

import com.nagoorkhan.inventoryservice.model.InventoryVO;
import com.nagoorkhan.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public List<InventoryVO> isProductInStock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode);
    }
}
