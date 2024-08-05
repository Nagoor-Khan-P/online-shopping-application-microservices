package com.nagoorkhan.inventoryservice.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InventoryExceptionHandler.class)
    public ResponseEntity<ErrorResponseVO> handleApiException(InventoryExceptionHandler ex) {
        ErrorResponseVO errorResponse = new ErrorResponseVO(ex.getMessage(), ex.getStatusCode(), HttpStatus.valueOf(ex.getStatusCode()).getReasonPhrase());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(ex.getStatusCode()));
    }
}
