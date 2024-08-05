package com.nagoorkhan.orderservice.exceptionhandler;

import lombok.Getter;

@Getter
public class OrderExceptionHandler extends RuntimeException{

    private final int statusCode;
    public OrderExceptionHandler(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
