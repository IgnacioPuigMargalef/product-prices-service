package com.nacho.productpricesservice.infraestructure.input.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PriceResponse(
        Integer productId,
        Integer brandId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Double price,
        Integer rate
) {
}
