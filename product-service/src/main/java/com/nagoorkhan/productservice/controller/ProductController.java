package com.nagoorkhan.productservice.controller;

import com.nagoorkhan.productservice.mapper.ProductRequestMapper;
import com.nagoorkhan.productservice.mapper.ProductResponseMapper;
import com.nagoorkhan.productservice.model.business.ProductVO;
import com.nagoorkhan.productservice.model.request.ProductRequestVO;
import com.nagoorkhan.productservice.model.response.ProductResponseVO;
import com.nagoorkhan.productservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Products API", description = "Products API to create, modify, fetch and delete the products")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRequestMapper productRequestMapper;

    private final ProductResponseMapper productResponseMapper;

    private final ProductService productService;


    @Operation(summary = "Create a product", description = "Creates a product with given ProductVO", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ProductRequestVO.class))))
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ProductResponseVO.class)))
    @PostMapping
    public ResponseEntity<ProductResponseVO> createProduct(@RequestBody ProductRequestVO productRequestVO) {
        ProductVO productVO = productRequestMapper.productRequestVOTOProductVO(productRequestVO);
        return ResponseEntity.ok(productResponseMapper.productVOTOProductResponseVO(productService.createProduct(productVO)));

    }

    @Operation(summary = "Fetch all products", description = "Fetch all available products in the inventory")
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ProductResponseVO.class)))
    @GetMapping
    public ResponseEntity<List<ProductResponseVO>> fetchAllProducts() {
        List<ProductVO> products = productService.fetchAllProducts();
        return ResponseEntity.ok(products.stream().map(productResponseMapper::productVOTOProductResponseVO).collect(Collectors.toList()));
    }

    @Operation(summary = "Fetch a product", description = "Fetch product for the given productId")
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ProductResponseVO.class)))
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseVO> fetchProduct(@PathVariable("productId") String productId) {
        return ResponseEntity.ok(productResponseMapper.productVOTOProductResponseVO(productService.fetchProduct(productId)));
    }

    @Operation(summary = "Modify a product", description = "Modify the Product with updated ProductRequestVO", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ProductRequestVO.class))))
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ProductResponseVO.class)))
    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponseVO> modifyProduct(@PathVariable("productId") String productId, @RequestBody ProductRequestVO productRequestVO) {
        ProductVO productVO = productRequestMapper.productRequestVOTOProductVO(productRequestVO);
        productVO.setPid(productId);
        return ResponseEntity.ok(productResponseMapper.productVOTOProductResponseVO(productService.modifyProduct(productVO)));
    }

    @Operation(summary = "Delete a product", description = "Deletes a product with given productId")
    @ApiResponse(responseCode = "200", description = "Success")
    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable("productId") String productId) {
        productService.deleteProduct(productId);
    }
}
