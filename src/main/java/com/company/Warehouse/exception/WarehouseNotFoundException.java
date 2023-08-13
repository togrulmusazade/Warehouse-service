package com.company.Warehouse.exception;

public class WarehouseNotFoundException extends RuntimeException{
    public WarehouseNotFoundException(String msg) {
        super(msg);
    }
}
