package com.nagoorkhan.inventoryservice.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public record ErrorResponseVO(String message, int statusCode, String error) {
    public ErrorResponseVO(String message, int statusCode, String error) {
        this.message = message;
        this.statusCode = statusCode;
        this.error = error;
    }
}
