
INSERT INTO tool (id, tool_code, tool_type, brand, daily_charge) VALUES
                                                                     (1, 'JAKR', 'Type1', 'BrandA', 10.0),
                                                                     (2, 'LADW', 'Type2', 'BrandB', 12.5),
                                                                     (3, 'CHNS', 'Type1', 'BrandA', 9.0);

INSERT INTO checkout (id, tool_id, rental_days, discount_percent, checkout_date) VALUES
        (1, 1, 5, 10, '2023-08-10'),
        (2, 2, 3, 5, '2023-08-10');
