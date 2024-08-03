package com.nagoorkhan.productservice.mapper;

import com.nagoorkhan.productservice.model.business.ProductVO;
import com.nagoorkhan.productservice.model.request.ProductRequestVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper {

    ProductVO productRequestVOTOProductVO(ProductRequestVO productRequestVO);
}
