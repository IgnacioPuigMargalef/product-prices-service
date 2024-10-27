package com.nacho.productpricesservice.infraestructure.input.mapper;

import com.nacho.productpricesservice.domain.model.Prices;
import com.nacho.productpricesservice.infraestructure.input.response.PriceResponse;
import org.mapstruct.Mapper;

@Mapper
public interface PriceRestMapper {

    PriceResponse toPriceResponse(Prices prices);

}
