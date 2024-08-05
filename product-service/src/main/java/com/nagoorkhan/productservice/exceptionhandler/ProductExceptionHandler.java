package com.nagoorkhan.productservice.exceptionhandler;

import lombok.Getter;

@Getter
public class ProductExceptionHandler extends RuntimeException {
    private final int statusCode;
    public ProductExceptionHandler(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
