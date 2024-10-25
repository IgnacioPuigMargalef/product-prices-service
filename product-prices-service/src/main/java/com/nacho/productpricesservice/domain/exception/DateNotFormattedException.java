package com.nacho.productpricesservice.domain.exception;

public class DateNotFormattedException extends RuntimeException {
    public DateNotFormattedException(String message) {
        super(message);
    }
}
