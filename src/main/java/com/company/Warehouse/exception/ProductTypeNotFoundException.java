package com.company.Warehouse.exception;

public class ProductTypeNotFoundException extends RuntimeException {
    public ProductTypeNotFoundException(String msg) {
        super(msg);
    }
}
