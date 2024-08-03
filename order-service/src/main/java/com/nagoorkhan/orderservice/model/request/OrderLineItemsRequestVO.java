package com.nagoorkhan.orderservice.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsRequestVO {

    private String skuCode;
    private BigDecimal price;
    private Long quantity;
}
