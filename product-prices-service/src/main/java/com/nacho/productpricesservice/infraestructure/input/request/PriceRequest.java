package com.nacho.productpricesservice.infraestructure.input.request;

public record PriceRequest(
        String dateRequest,
        Integer productId,
        Integer brandId
) {
}
