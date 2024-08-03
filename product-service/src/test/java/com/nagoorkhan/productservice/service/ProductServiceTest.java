package com.nagoorkhan.productservice.service;

import com.nagoorkhan.productservice.exceptionhandler.ProductExceptionHandler;
import com.nagoorkhan.productservice.model.business.ProductVO;
import com.nagoorkhan.productservice.repository.ProductRepository;
import com.nagoorkhan.productservice.validator.ProductValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    private final BigDecimal price = new BigDecimal("1699.99");

    @InjectMocks
    private ProductService productService;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductValidator productValidator;

    @Test
    void testCreateProduct() {
        when(productRepository.insert(any(ProductVO.class))).thenReturn(createProductVO());
        ProductVO productVO = productService.createProduct(new ProductVO("Laptop", price, "Apple Macbook M3"));

        assertEquals("1", productVO.getPid());

    }

    @Test
    void testFetchAllProducts() {
        when(productRepository.findAll()).thenReturn(List.of(createProductVO()));
        List<ProductVO> productVOs = productService.fetchAllProducts();

        assertEquals(1, productVOs.size());
    }

    @Test
    void testFetchProduct() {
        when(productRepository.findById(anyString())).thenReturn(Optional.of(createProductVO()));
        doNothing().when(productValidator).validateProductId(any());
        ProductVO productVO = productService.fetchProduct("1");

        assertEquals("1", productVO.getPid());
        assertEquals("Laptop", productVO.getProductName());
        assertEquals(price, productVO.getPrice());
        assertEquals("Apple Macbook M3", productVO.getDescription());
    }

    @Test
    void testFetchProductWithException() {
        when(productRepository.findById(anyString())).thenReturn(Optional.empty());
        doNothing().when(productValidator).validateProductId(any());

        assertThrows(ProductExceptionHandler.class, () -> {
            productService.fetchProduct("1");
        });
    }

    @Test
    void testModifyProduct() {
        ProductVO productVO = createProductVO();
        productVO.setProductName("Modified Product Name");
        when(productRepository.save(any(ProductVO.class))).thenReturn(productVO);
//        doNothing().when(productValidator).validateProductId(any());

        productVO = productService.modifyProduct(createProductVO());

        assertEquals("1", productVO.getPid());
        assertEquals("Modified Product Name", productVO.getProductName());
        assertEquals(price, productVO.getPrice());
        assertEquals("Apple Macbook M3", productVO.getDescription());
    }



    private ProductVO createProductVO() {
        return new ProductVO("1", "Laptop", price, "Apple Macbook M3");
    }

}
