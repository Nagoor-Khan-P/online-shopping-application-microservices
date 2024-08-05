package com.nagoorkhan.inventoryservice.exceptionhandler;

import lombok.Getter;

@Getter
public class InventoryExceptionHandler extends RuntimeException{

    private final int statusCode;
    public InventoryExceptionHandler(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

}
