package com.nacho.productpricesservice.domain.model;

import com.nacho.productpricesservice.domain.model.valueObject.Currency;
import com.nacho.productpricesservice.domain.model.valueObject.DateValueObject;

public class Prices {

    private Integer brandId;
    private DateValueObject startDate;
    private DateValueObject endDate;
    private Integer productId;
    private Double price;
    private Currency currency;
    private Integer priority;

    public Prices(
            Integer brandId,
            String startDate,
            String endDate,
            Integer productId,
            Double price,
            String currency,
            Integer priority
            ) {
        this.brandId = brandId;
        this.startDate = new DateValueObject(startDate);
        this.endDate = new DateValueObject(endDate);
        this.productId = productId;
        this.price = price;
        this.currency = new Currency(currency);
    }

}
