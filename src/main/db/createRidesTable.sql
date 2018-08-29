CREATE TABLE rides (ID SERIAL,
    VENDOR_ID SMALLINT,
    PICKUP_DATETIME TIMESTAMP,
    DROPOFF_DATETIME TIMESTAMP,
    PASSENGER_COUNT SMALLINT,
    TRIP_DISTANCE float8,
    RATE_CODE_ID SMALLINT,
    STORE_AND_FWD_FLAG char(1),
    PICKUP_LOCATION_ID SMALLINT,
    DROPOFF_LOCATION_ID SMALLINT,
    PAYMENT_TYPE SMALLINT,
    FARE_AMOUNT float8,
    EXTRA float8,
    MTA_TAX float8,
    TIP_AMOUNT float8,
    TOLLS_AMOUNT float8,
    IMPROVEMENT_SURCHARGE float8,
    TOTAL_AMOUNT float8);