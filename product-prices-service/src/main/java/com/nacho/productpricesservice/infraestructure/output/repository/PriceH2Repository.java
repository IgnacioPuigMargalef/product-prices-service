package com.nacho.productpricesservice.infraestructure.output.repository;

import com.nacho.productpricesservice.domain.exception.ProductPriceNotFoundException;
import com.nacho.productpricesservice.domain.model.Prices;
import com.nacho.productpricesservice.infraestructure.output.entity.PriceEntity;
import com.nacho.productpricesservice.infraestructure.output.mapper.PriceRowMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
@AllArgsConstructor
public class PriceH2Repository {

    private NamedParameterJdbcTemplate jdbcTemplate;
    private PriceRowMapper priceRowMapper;

    public Prices getPrice(String date, Integer productId, Integer brandId) {
        final PriceEntity priceEntity;
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("date", date);
        params.addValue("productId", productId);
        params.addValue("brandId", brandId);

        try {
            priceEntity = jdbcTemplate.queryForObject(
                    Queries.GET_PRICES_BY_PRODUCT_AND_DATE_AND_BRAND,
                    params,
                    priceRowMapper
            );
        } catch (DataAccessException e) {
            throw new ProductPriceNotFoundException();
        }

        return new Prices(
                priceEntity.getBrandId(),
                priceEntity.getStartDate(),
                priceEntity.getEndDate(),
                priceEntity.getProductId(),
                priceEntity.getPrice(),
                priceEntity.getCurrency(),
                priceEntity.getPriority(),
                priceEntity.getPriceList()
        );
    }
}
