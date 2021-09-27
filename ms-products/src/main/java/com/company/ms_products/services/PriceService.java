package com.company.ms_products.services;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import com.company.ms_products.dto.PriceDateProductIdBrandIdDto;
import com.company.ms_products.dto.PriceDto;

/**
 * Price Service Interface. Here is where defining the methods of  business logic
 * 
 * @author Miguel Pedraz Hernandez
 * @version 0.1
 *
 */
public interface PriceService {

	/**
	 * Get all prices
	 * 
	 * @param pageNo   Page number
	 * @param pageSize Number of prices by page
	 * @param sortBy   Attribute to sort
	 * 
	 * @return Page<PriceDto>
	 */
	Page<PriceDto> getAllPrices(Integer pageNo, Integer pageSize, String sortBy);

	/**
	 * Method to get the  prices by application date, product id, and brand id
	 * 
	 * @param pageNo    Page number
	 * @param pageSize  Number of prices by page
	 * @param sortBy    Attribute to sort
	 * @param date      Application date
	 * @param productId Product id
	 * @param barandId  Brand id
	 * 
	 * @return Page<PriceDto> 
	 */
	Page<PriceDateProductIdBrandIdDto> getByDateIdProductIdBrand(Integer pageNo, Integer pageSize, String sortBy, LocalDateTime date,
			Long productId, Long barandId);

}