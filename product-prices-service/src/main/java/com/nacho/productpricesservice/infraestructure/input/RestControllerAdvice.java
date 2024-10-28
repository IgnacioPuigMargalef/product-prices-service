package com.nacho.productpricesservice.infraestructure.input;

import com.nacho.productpricesservice.domain.exception.CurrencyTypeException;
import com.nacho.productpricesservice.domain.exception.ProductPriceNotFoundException;
import com.nacho.productpricesservice.infraestructure.input.response.CustomErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@org.springframework.web.bind.annotation.RestControllerAdvice
@Slf4j
public class RestControllerAdvice {

    private static final String ERROR_GETTING_PRICE = "ERROR_PRICE_NOT_FOUND";
    private static final String ERROR_CURRENCY_TYPE = "ERROR_CURRENCY_TYPE_NOT_FOUND";

    @ExceptionHandler(CurrencyTypeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CustomErrorResponse handleCurrencyTypeException(CurrencyTypeException e) {
        log.error("Error handling the currency type, returning {}", ERROR_CURRENCY_TYPE);
        return new CustomErrorResponse(ERROR_CURRENCY_TYPE);
    }

    @ExceptionHandler(ProductPriceNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CustomErrorResponse handleProductPriceNotFoundException(ProductPriceNotFoundException e) {
        log.error("Error founding product price, returning {}", ERROR_GETTING_PRICE);
        return new CustomErrorResponse(ERROR_GETTING_PRICE);
    }




}
