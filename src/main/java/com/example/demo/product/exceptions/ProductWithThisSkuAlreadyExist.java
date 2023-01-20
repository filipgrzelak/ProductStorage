package com.example.demo.product.exceptions;

public class ProductWithThisSkuAlreadyExist extends RuntimeException{
    public ProductWithThisSkuAlreadyExist(String message) {
        super(message);
    }
}
