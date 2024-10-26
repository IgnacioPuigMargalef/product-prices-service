package com.nacho.productpricesservice.infraestructure.output;

import com.nacho.productpricesservice.application.port.output.PricesOutPort;
import com.nacho.productpricesservice.domain.model.Prices;
import org.springframework.stereotype.Component;

@Component
public class PricesOutH2Adapter implements PricesOutPort {

    @Override
    public Prices getProductPrices(String date, Integer productId, Integer brandId) {
        return null;
    }
}
