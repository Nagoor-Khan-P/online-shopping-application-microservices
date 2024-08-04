package com.nagoorkhan.inventoryservice.mapper;

import com.nagoorkhan.inventoryservice.model.InventoryResponseVO;
import com.nagoorkhan.inventoryservice.model.InventoryVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InventoryResponseMapper {

    @Mapping(target = "isInStock", expression = "java(evaluateStock(inventoryVO))")
    InventoryResponseVO toInventoryResponseVO(InventoryVO inventoryVO);

    default Boolean evaluateStock(InventoryVO inventoryVO) {
        return inventoryVO.getQuantity() > 0;
    }
}
