CREATE TABLE orders
(
    ID              BIGSERIAL PRIMARY KEY,
    TRACKING_NUMBER VARCHAR(255) UNIQUE NOT NULL,
    ITEMS           JSONB
);
