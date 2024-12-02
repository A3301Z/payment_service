-- V2__insert_initial_data.sql
INSERT INTO products (id, user_id, product_type, account_number, balance)
VALUES
    ('ae8f1bc6-3824-4d74-81b5-ee8f68391b88', 1, 'ACCOUNT', 'account_001', 150000),
    ('b929eff8-c4bd-4451-b871-7765a3654cba', 1, 'CARD', 'account_002', 5400),
    ('39d1a13e-aae0-47b2-973b-91168fcaa764', 2, 'ACCOUNT', 'account_003', 2000),
    ('5acb0f7e-5d36-4276-b750-f23493952d95', 2, 'ACCOUNT', 'account_004', 14000),
    ('0ca10848-16bf-42ae-8500-9ea664c772cd', 2, 'CARD', 'account_005', 80000);