
CREATE TABLE tool (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      tool_code VARCHAR(10) NOT NULL,
                      tool_type VARCHAR(50) NOT NULL,
                      brand VARCHAR(50) NOT NULL,
                      daily_charge DECIMAL(10, 2) NOT NULL
);


CREATE TABLE checkout (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          tool_id INT NOT NULL,
                          rental_days INT NOT NULL,
                          discount_percent INT NOT NULL,
                          checkout_date DATE NOT NULL,
                          FOREIGN KEY (tool_id) REFERENCES tool(id)
);

