CREATE SCHEMA IF NOT EXISTS pricesdb;

CREATE TABLE IF NOT EXISTS PRICES (
    ID              INTEGER         PRIMARY KEY, -- Added
    BRAND_ID        INTEGER         NOT NULL,
    START_DATE      TIMESTAMP       NOT NULL,
    END_DATE        TIMESTAMP       NOT NULL,
    PRICE_LIST      INTEGER         NOT NULL,
    PRODUCT_ID      INTEGER         NOT NULL,
    PRIORITY        INTEGER         NOT NULL,
    PRICE           DECIMAL(10, 2)  NOT NULL,
    CURR            VARCHAR         NOT NULL
)