package com.nagoorkhan.inventoryservice.controller;

import com.nagoorkhan.inventoryservice.mapper.InventoryResponseMapper;
import com.nagoorkhan.inventoryservice.model.InventoryResponseVO;
import com.nagoorkhan.inventoryservice.model.InventoryVO;
import com.nagoorkhan.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;
    private final InventoryResponseMapper inventoryResponseMapper;
    @GetMapping
    public ResponseEntity<List<InventoryResponseVO>> getProductsStock(
            @RequestParam(value = "skuCodes") List<String> skuCodes
    ) {
        List<InventoryVO> inventoryVOS = inventoryService.getProductsStock(skuCodes);
        return ResponseEntity.ok(inventoryVOS.stream().map(inventoryResponseMapper::toInventoryResponseVO).toList());
    }
}
