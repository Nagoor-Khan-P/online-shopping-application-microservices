package com.nagoorkhan.orderservice.mapper;

import com.nagoorkhan.orderservice.model.business.OrderLineItemsVO;
import com.nagoorkhan.orderservice.model.request.OrderLineItemsRequestVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderLineItemsRequestMapper {
    OrderLineItemsVO toOrderLineItemsVO(OrderLineItemsRequestVO orderLineItemsRequestVO);
}
