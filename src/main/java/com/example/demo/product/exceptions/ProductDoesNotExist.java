package com.example.demo.product.exceptions;

public class ProductDoesNotExist extends RuntimeException{
    public ProductDoesNotExist(String message) {
        super(message);
    }
}
