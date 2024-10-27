package com.nacho.productpricesservice.infraestructure.output.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PriceEntity {
    private Integer id;
    private Integer brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priceList;
    private Integer productId;
    private Integer priority;
    private Double price;
    private String currency;
}

