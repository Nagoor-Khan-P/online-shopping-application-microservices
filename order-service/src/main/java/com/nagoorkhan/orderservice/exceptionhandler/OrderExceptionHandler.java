package com.nagoorkhan.orderservice.exceptionhandler;

public class OrderExceptionHandler extends RuntimeException{
    public OrderExceptionHandler(String message) {
        super(message);
    }
}
