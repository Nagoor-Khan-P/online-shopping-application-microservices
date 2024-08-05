package com.nagoorkhan.inventoryservice.service;

import com.nagoorkhan.inventoryservice.exceptionhandler.InventoryExceptionHandler;
import com.nagoorkhan.inventoryservice.model.InventoryVO;
import com.nagoorkhan.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryVO> getProductsStock(List<String> skuCodes) {
        List<InventoryVO> inventoryVOS = inventoryRepository.findBySkuCodeIn(skuCodes);
        Set<String> availableProducts = inventoryVOS.stream().map(InventoryVO::getSkuCode).collect(Collectors.toSet());
        for(String skuCode : skuCodes) {
            if(!availableProducts.contains(skuCode)) {
                throw  new InventoryExceptionHandler("Product with skuCode"+ skuCode + " is not available in inventory.", 500);
            }
        }
        return inventoryVOS;
    }
}
