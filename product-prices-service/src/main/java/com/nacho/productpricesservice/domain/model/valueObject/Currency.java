package com.nacho.productpricesservice.domain.model.valueObject;

import com.nacho.productpricesservice.domain.exception.CurrencyTypeException;

public class Currency {

    private CurrencyType currencyType;

    public Currency(String currency) {
        setCurrencyType(currency);
    }

    public void setCurrencyType(String currency) {
        try {
            currencyType = CurrencyType.valueOf(currency.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new CurrencyTypeException();
        }
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }
}
