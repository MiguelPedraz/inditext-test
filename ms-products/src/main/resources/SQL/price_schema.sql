DROP TABLE IF EXISTS billionaires;

CREATE TABLE price (
  brand_id INT NOT NULL,
  start_date DATETIME NOT NULL,
  end_date DATETIME NOT NULL,
  price_list INT NOT NULL,
  product_id INT NOT NULL,
  priority INT NOT NULL,
  price DECIMAL NOT NULL,
  curr VARCHAR(250) NOT NULL
);