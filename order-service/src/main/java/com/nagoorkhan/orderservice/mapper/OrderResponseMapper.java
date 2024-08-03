package com.nagoorkhan.orderservice.mapper;

import com.nagoorkhan.orderservice.model.business.OrderVO;
import com.nagoorkhan.orderservice.model.response.OrderResponseVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {OrderLineItemsResponseMapper.class})
public interface OrderResponseMapper {

    @Mapping(source = "orderLineItemVOS", target = "orderLineItems")
    OrderResponseVO orderVOToOrderResponseVO(OrderVO orderVO);
}
