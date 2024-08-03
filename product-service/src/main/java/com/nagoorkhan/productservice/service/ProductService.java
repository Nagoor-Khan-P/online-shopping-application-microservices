package com.nagoorkhan.productservice.service;

import com.nagoorkhan.productservice.exceptionhandler.ProductExceptionHandler;
import com.nagoorkhan.productservice.model.business.ProductVO;
import com.nagoorkhan.productservice.repository.ProductRepository;
import com.nagoorkhan.productservice.validator.ProductValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {


    private final ProductRepository productRepository;
    private final ProductValidator productValidator;

    public ProductVO createProduct(ProductVO productVO) {
        productVO = productRepository.insert(productVO);
        log.info("Product is created successfully with id {}", productVO.getPid());
        return productVO;
    }

    public List<ProductVO> fetchAllProducts() {
        List<ProductVO> products = productRepository.findAll();
        log.info("All products are fetched successfully {}", products);
        return products;
    }

    public ProductVO fetchProduct(String productId) {
        productValidator.validateProductId(productId);
        ProductVO productVO = productRepository.findById(productId).orElse(null);
        if(productVO == null) {
            throw new ProductExceptionHandler("Product is not available in the inventory");
        }
        log.info("Product is fetched successfully for the given product id {}", productId);
        return productVO;
    }

    public ProductVO modifyProduct(ProductVO productVO) {
        productValidator.validateProductVO(productVO);
        productVO = productRepository.save(productVO);
        log.info("Product is updated  successfully {}", productVO);
        return productVO;
    }

    public void deleteProduct(String productId) {
        productValidator.validateProductId(productId);
        productRepository.deleteById(productId);
        log.info("Product is deleted  successfully {}", productId);
    }
}
