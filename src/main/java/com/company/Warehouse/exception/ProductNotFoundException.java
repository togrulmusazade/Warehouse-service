package com.company.Warehouse.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String msg) {
        super(msg);
    }
}
