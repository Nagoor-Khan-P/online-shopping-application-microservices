package com.nagoorkhan.inventoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class InventoryResponseVO {
    private Long id;
    private String skuCode;
    private Long quantity;
}
