package com.nacho.productpricesservice.infraestructure.output;

import com.nacho.productpricesservice.application.port.output.PricesOutPort;
import com.nacho.productpricesservice.domain.model.Prices;
import com.nacho.productpricesservice.infraestructure.output.repository.PriceH2Repository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class PricesOutH2Adapter implements PricesOutPort {

    private PriceH2Repository priceH2Repository;

    @Override
    public Prices getProductPrices(String date, Integer productId, Integer brandId) {
        log.info("Getting product prices with date {}, product {} and brand {} from database", date, productId, brandId);
        return priceH2Repository.getPrice(date, productId, brandId);
    }
}
