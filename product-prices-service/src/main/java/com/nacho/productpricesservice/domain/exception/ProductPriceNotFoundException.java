package com.nacho.productpricesservice.domain.exception;

public class ProductPriceNotFoundException extends RuntimeException {
    public ProductPriceNotFoundException(String message) {
        super(message);
    }
}
