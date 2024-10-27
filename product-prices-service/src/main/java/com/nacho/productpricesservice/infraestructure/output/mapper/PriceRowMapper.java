package com.nacho.productpricesservice.infraestructure.output.mapper;

import com.nacho.productpricesservice.infraestructure.output.entity.PriceEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class PriceRowMapper implements RowMapper<PriceEntity> {

    @Override
    public PriceEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        final PriceEntity priceEntity = new PriceEntity();
        priceEntity.setId(rs.getInt("ID"));
        priceEntity.setBrandId(rs.getInt("BRAND_ID"));
        priceEntity.setStartDate(rs.getTimestamp("START_DATE").toLocalDateTime());
        priceEntity.setEndDate(rs.getTimestamp("END_DATE").toLocalDateTime());
        priceEntity.setPriceList(rs.getInt("PRICE_LIST"));
        priceEntity.setProductId(rs.getInt("PRODUCT_ID"));
        priceEntity.setPriority(rs.getInt("PRIORITY"));
        priceEntity.setPrice(rs.getDouble("PRICE"));
        priceEntity.setCurrency(rs.getString("CURR"));
        return priceEntity;
    }
}
