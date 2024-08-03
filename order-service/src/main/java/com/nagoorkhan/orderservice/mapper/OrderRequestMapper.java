package com.nagoorkhan.orderservice.mapper;

import com.nagoorkhan.orderservice.model.business.OrderVO;
import com.nagoorkhan.orderservice.model.request.OrderRequestVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {OrderLineItemsRequestMapper.class})
public interface OrderRequestMapper {

    @Mapping(target = "orderNum", expression = "java(generateOrderUUID())")
    @Mapping(source = "orderLineItems", target = "orderLineItemVOS")
    OrderVO orderRequestVOToOrderVO(OrderRequestVO orderRequestVO);

    default String generateOrderUUID() {
        return UUID.randomUUID().toString();
    }
}
