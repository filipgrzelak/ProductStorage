package com.example.demo.product.exceptions;

public class ProductWithThisSkuDoesNotExistException extends RuntimeException{
    public ProductWithThisSkuDoesNotExistException(String message) {
        super(message);
    }
}
