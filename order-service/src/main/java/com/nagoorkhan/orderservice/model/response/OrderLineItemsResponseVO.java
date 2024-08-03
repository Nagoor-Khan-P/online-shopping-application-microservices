package com.nagoorkhan.orderservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsResponseVO {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Long quantity;
}
