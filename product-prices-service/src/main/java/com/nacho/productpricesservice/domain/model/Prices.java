package com.nacho.productpricesservice.domain.model;

import com.nacho.productpricesservice.domain.model.valueObject.Currency;

import java.time.LocalDateTime;

public class Prices {

    private Integer brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer productId;
    private Double price;
    private Currency currency;
    private Integer priority;
    private Integer rate;

    public Prices(
            Integer brandId,
            LocalDateTime startDate,
            LocalDateTime endDate,
            Integer productId,
            Double price,
            String currency,
            Integer priority,
            Integer rate
            ) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.productId = productId;
        this.price = price;
        this.currency = new Currency(currency);
        this.rate = rate;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
