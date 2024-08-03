package com.nagoorkhan.productservice.exceptionhandler;

public class ProductExceptionHandler extends RuntimeException {
    public ProductExceptionHandler(String message) {
        super(message);
    }
}
