package com.nacho.productpricesservice.infraestructure.input;

import com.nacho.productpricesservice.application.port.input.PricesInPort;
import com.nacho.productpricesservice.domain.model.Prices;
import com.nacho.productpricesservice.infraestructure.input.mapper.PriceRestMapper;
import com.nacho.productpricesservice.infraestructure.input.request.PriceRequest;
import com.nacho.productpricesservice.infraestructure.input.response.PriceResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/price")
@Slf4j
@AllArgsConstructor
public class PricesInHttpAdapter {

    private final PricesInPort pricesInPort;
    private final PriceRestMapper mapper;

    @PostMapping("/get")
    public ResponseEntity<PriceResponse> getProductPrice(
            @RequestBody PriceRequest productPriceRequest
    ) {
        log.info("Getting price for product: {}", productPriceRequest);
        final Prices price = pricesInPort.getProductPrices(
                productPriceRequest.dateRequest(),
                productPriceRequest.productId(),
                productPriceRequest.brandId()
        );

        final PriceResponse priceResponse = mapper.toPriceResponse(price);
        log.info("Price response: {}", priceResponse);

        return new ResponseEntity<PriceResponse>(priceResponse, HttpStatus.OK);
    }
}
