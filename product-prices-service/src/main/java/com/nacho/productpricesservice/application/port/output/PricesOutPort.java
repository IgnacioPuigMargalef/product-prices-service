package com.nacho.productpricesservice.application.port.output;

import com.nacho.productpricesservice.domain.model.Prices;

public interface PricesOutPort {

    Prices getProductPrices(String date, Integer productId, Integer brandId);

}
