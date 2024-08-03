package com.nagoorkhan.inventoryservice.mapper;

import com.nagoorkhan.inventoryservice.model.InventoryResponseVO;
import com.nagoorkhan.inventoryservice.model.InventoryVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryResponseMapper {

    InventoryResponseVO toInventoryResponseVO(InventoryVO inventoryVO);
}
