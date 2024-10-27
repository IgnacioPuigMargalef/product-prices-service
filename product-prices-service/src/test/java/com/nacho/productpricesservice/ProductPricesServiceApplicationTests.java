package com.nacho.productpricesservice;

import com.nacho.productpricesservice.infraestructure.input.response.PriceResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@DisplayName("Tests para ProductPricesServiceApplicationTests")
class ProductPricesServiceApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Test para getProductPrices con bateria de ejemplos")
    void getProductPrices() {
        ///Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        final String JSON_TEST1 = "{\n" + "    \"productId\": 35455,\n" + "    \"brandId\": 1,\n" + "    \"dateRequest\": \"14/06/2020-10:00:00\"\n" + "}";
        ///Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        final String JSON_TEST2 = "{\n" + "    \"productId\": 35455,\n" + "    \"brandId\": 1,\n" + "    \"dateRequest\": \"14/06/2020-16:00:00\"\n" + "}";
        ///Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
        final String JSON_TEST3 = "{\n" + "    \"productId\": 35455,\n" + "    \"brandId\": 1,\n" + "    \"dateRequest\": \"14/06/2020-21:00:00\"\n" + "}";
        ///Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
        final String JSON_TEST4 = "{\n" + "    \"productId\": 35455,\n" + "    \"brandId\": 1,\n" + "    \"dateRequest\": \"15/06/2020-10:00:00\"\n" + "}";
        ///Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
        final String JSON_TEST5 = "{\n" + "    \"productId\": 35455,\n" + "    \"brandId\": 1,\n" + "    \"dateRequest\": \"16/06/2020-21:00:00\"\n" + "}";

        ///Realizo las 5 peticiones a la API
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final ResponseEntity<PriceResponse> response1 = restTemplate.exchange("/api/v1/price/get", HttpMethod.POST, new HttpEntity<>(JSON_TEST1, headers), PriceResponse.class);
        final ResponseEntity<PriceResponse> response2 = restTemplate.exchange("/api/v1/price/get", HttpMethod.POST, new HttpEntity<>(JSON_TEST2, headers), PriceResponse.class);
        final ResponseEntity<PriceResponse> response3 = restTemplate.exchange("/api/v1/price/get", HttpMethod.POST, new HttpEntity<>(JSON_TEST3, headers), PriceResponse.class);
        final ResponseEntity<PriceResponse> response4 = restTemplate.exchange("/api/v1/price/get", HttpMethod.POST, new HttpEntity<>(JSON_TEST4, headers), PriceResponse.class);
        final ResponseEntity<PriceResponse> response5 = restTemplate.exchange("/api/v1/price/get", HttpMethod.POST, new HttpEntity<>(JSON_TEST5, headers), PriceResponse.class);

        ///Compruebo que todas vienen con objeto de respuesta
        final PriceResponse priceResponse1 = response1.getBody();
        final PriceResponse priceResponse2 = response2.getBody();
        final PriceResponse priceResponse3 = response3.getBody();
        final PriceResponse priceResponse4 = response4.getBody();
        final PriceResponse priceResponse5 = response5.getBody();

        assertNotNull(priceResponse1);
        assertNotNull(priceResponse2);
        assertNotNull(priceResponse3);
        assertNotNull(priceResponse4);
        assertNotNull(priceResponse5);

        ///Compruebo el precio final de estas
        assertEquals(priceResponse1.price(), 35.50);
        assertEquals(priceResponse2.price(), 25.45);
        assertEquals(priceResponse3.price(), 35.50);
        assertEquals(priceResponse4.price(), 30.50);
        assertEquals(priceResponse5.price(), 38.95);
    }


}
