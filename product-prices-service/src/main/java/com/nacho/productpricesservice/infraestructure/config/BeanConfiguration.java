package com.nacho.productpricesservice.infraestructure.config;

import com.nacho.productpricesservice.application.port.output.PricesOutPort;
import com.nacho.productpricesservice.application.service.PricesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public PricesService pricesService(final PricesOutPort pricesOutPort) {
        return new PricesService(pricesOutPort);
    }
}
