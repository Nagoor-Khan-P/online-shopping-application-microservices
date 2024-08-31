package com.nagoorkhan.orderservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseVO {

    private Long oid;
    private String orderNum;
    private List<OrderLineItemsResponseVO> orderLineItems;
    private String message;

}
