package com.nagoorkhan.orderservice.exceptionhandler;

import lombok.Getter;

public record ErrorResponseVO(String message, int statusCode, String error) {
    public ErrorResponseVO(String message, int statusCode, String error) {
        this.message = message;
        this.statusCode = statusCode;
        this.error = error;
    }
}
