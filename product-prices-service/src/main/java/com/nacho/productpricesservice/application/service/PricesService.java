package com.nacho.productpricesservice.application.service;

import com.nacho.productpricesservice.application.port.input.PricesInPort;
import com.nacho.productpricesservice.application.port.output.PricesOutPort;
import com.nacho.productpricesservice.domain.model.Prices;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PricesService implements PricesInPort {

    private PricesOutPort pricesOutPort;

    @Override
    public Prices getProductPrices(String date, Integer productId, Integer brandId) {
        return pricesOutPort.getProductPrices(date, productId, brandId);
    }
}
