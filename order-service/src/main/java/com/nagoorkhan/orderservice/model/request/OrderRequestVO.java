package com.nagoorkhan.orderservice.model.request;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequestVO {
    private List<OrderLineItemsRequestVO> orderLineItems;
}
