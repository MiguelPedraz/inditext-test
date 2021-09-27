INSERT INTO price_list (
	start_date,
	end_date,
  	priority,
  	price,
  	curr,
  	brand_id,
  	product_id
) VALUES
  (parsedatetime('2020-06-14 00:00:00', 'yyyy-MM-dd hh:mm:ss'),parsedatetime('2020-12-31 23:59:59', 'yyyy-MM-dd hh:mm:ss'),0,35.50,'EUR',1,35455),
  (parsedatetime('2020-06-14 15:00:00', 'yyyy-MM-dd hh:mm:ss'),parsedatetime('2020-06-14 18:30:00', 'yyyy-MM-dd hh:mm:ss'),1,25.45,'EUR',1,35455),
  (parsedatetime('2020-06-15 00:00:00', 'yyyy-MM-dd hh:mm:ss'),parsedatetime('2020-06-15 11:00:00', 'yyyy-MM-dd hh:mm:ss'),1,30.50,'EUR',1,35455),
  (parsedatetime('2020-06-15 16:00:00', 'yyyy-MM-dd hh:mm:ss'),parsedatetime('2020-12-31 23:59:59', 'yyyy-MM-dd hh:mm:ss'),1,38.95,'EUR',1,35455);
 
  
  
  