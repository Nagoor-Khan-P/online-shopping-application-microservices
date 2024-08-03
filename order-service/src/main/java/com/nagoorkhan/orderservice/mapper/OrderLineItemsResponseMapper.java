package com.nagoorkhan.orderservice.mapper;

import com.nagoorkhan.orderservice.model.business.OrderLineItemsVO;
import com.nagoorkhan.orderservice.model.request.OrderRequestVO;
import com.nagoorkhan.orderservice.model.response.OrderLineItemsResponseVO;
import com.nagoorkhan.orderservice.model.response.OrderResponseVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderLineItemsResponseMapper {
    OrderLineItemsResponseVO toOrderLineItemsResponseVO(OrderLineItemsVO orderLineItemsVO);
}
