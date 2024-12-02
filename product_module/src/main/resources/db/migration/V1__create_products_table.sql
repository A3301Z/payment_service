-- V1__create_products_table.sql
CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE products (
                          id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                          user_id NUMERIC(255) NOT NULL,
                          account_number VARCHAR(255) NOT NULL,
                          balance NUMERIC NOT NULL,
                          product_type VARCHAR(255) NOT NULL
);