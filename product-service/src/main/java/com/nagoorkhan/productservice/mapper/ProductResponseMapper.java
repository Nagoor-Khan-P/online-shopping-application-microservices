package com.nagoorkhan.productservice.mapper;

import com.nagoorkhan.productservice.model.business.ProductVO;
import com.nagoorkhan.productservice.model.response.ProductResponseVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductResponseMapper {

    ProductResponseVO productVOTOProductResponseVO(ProductVO productVO);
}