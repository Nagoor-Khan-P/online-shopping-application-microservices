package com.nagoorkhan.orderservice.mapper;

import com.nagoorkhan.orderservice.model.business.OrderVO;
import com.nagoorkhan.orderservice.model.response.OrderResponseVO;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {OrderLineItemsResponseMapper.class})
public abstract class OrderResponseMapper {

    @Mapping(target = "message", expression = "java(getOrderResponseMessage(orderVO))")
    @Mapping(source = "orderLineItemVOS", target = "orderLineItems")
    public abstract OrderResponseVO orderVOToOrderResponseVO(OrderVO orderVO);

    protected String getOrderResponseMessage(OrderVO orderVO) {
        if(orderVO.getOrderNum() != null && StringUtils.isNotEmpty(orderVO.getOrderNum())) {
            return "Order placed successfully.";
        }
        return "Oops!! order not placed.";
    }
}
