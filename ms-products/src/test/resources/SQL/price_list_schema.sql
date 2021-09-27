DROP TABLE IF EXISTS price_list;

CREATE TABLE price_list (
  id IDENTITY  PRIMARY KEY,
  start_date DATETIME NOT NULL,
  end_date DATETIME NOT NULL,
  priority INT NOT NULL,
  price DECIMAL NOT NULL,
  curr VARCHAR(3) NOT NULL,
  brand_id BIGINT NOT NULL,
  product_id BIGINT NOT NULL
);