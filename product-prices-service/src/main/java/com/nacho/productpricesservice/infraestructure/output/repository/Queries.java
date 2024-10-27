package com.nacho.productpricesservice.infraestructure.output.repository;

import com.nacho.productpricesservice.infraestructure.config.Constant;

public class Queries {
    public static final String GET_PRICES_BY_PRODUCT_AND_DATE_AND_BRAND =
            "SELECT * \n" +
                    "FROM PRICES\n" +
                    "WHERE BRAND_ID = :brandId \n" +
                    "    AND PRODUCT_ID = :productId \n" +
                    "    AND PARSEDATETIME(:date, '" + Constant.H2_DATE_FORMAT + "' ) BETWEEN START_DATE AND END_DATE\n" +
                    "ORDER BY PRIORITY DESC\n" +
                    "LIMIT 1";
}
