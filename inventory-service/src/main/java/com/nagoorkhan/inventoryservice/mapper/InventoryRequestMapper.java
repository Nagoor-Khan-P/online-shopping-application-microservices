package com.nagoorkhan.inventoryservice.mapper;

import com.nagoorkhan.inventoryservice.model.InventoryRequestVO;
import com.nagoorkhan.inventoryservice.model.InventoryVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InventoryRequestMapper {
    InventoryVO toInventoryVO(InventoryRequestVO inventoryRequestVO);
}
