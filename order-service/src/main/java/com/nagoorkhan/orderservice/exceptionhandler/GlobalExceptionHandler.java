package com.nagoorkhan.orderservice.exceptionhandler;

import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderExceptionHandler.class)
    public ResponseEntity<ErrorResponseVO> handleApiException(OrderExceptionHandler ex) {
        ErrorResponseVO errorResponse = new ErrorResponseVO(ex.getMessage(), ex.getStatusCode(), HttpStatus.valueOf(ex.getStatusCode()).getReasonPhrase());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(ex.getStatusCode()));
    }
}
