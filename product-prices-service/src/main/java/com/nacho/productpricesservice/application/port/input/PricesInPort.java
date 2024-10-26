package com.nacho.productpricesservice.application.port.input;

import com.nacho.productpricesservice.domain.model.Prices;

public interface PricesInPort {

    Prices getProductPrices(String date, Integer productId, Integer brandId);

}
