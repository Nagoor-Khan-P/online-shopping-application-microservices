package com.nagoorkhan.productservice.validator;

import com.nagoorkhan.productservice.exceptionhandler.ProductExceptionHandler;
import com.nagoorkhan.productservice.model.business.ProductVO;
import org.springframework.stereotype.Service;

@Service
public class ProductValidator {

    public void validateProductId(String productId) {
        if (productId.isEmpty()) {
            throw new ProductExceptionHandler("Product Id is missing", 500);
        }
    }

    public void validateProductVO(ProductVO productVO) {
        validateProductId(productVO.getPid());
    }
}
