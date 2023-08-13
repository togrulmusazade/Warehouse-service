package com.company.Warehouse.exception;

public class ProductGroupNotFoundException extends RuntimeException {
    public ProductGroupNotFoundException(String msg) {
        super(msg);
    }
}
