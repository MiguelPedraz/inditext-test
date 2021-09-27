package com.company.ms_products.controllers;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.ms_products.dto.PriceDateProductIdBrandIdDto;
import com.company.ms_products.dto.PriceDto;

/**
 * Price Controller Interface. 
 * Here is where defining the methods of  rest interface
 * 
 * @author Miguel Pedraz Hernandez
 * @version 0.1
 *
 */
public interface PriceController {

	/**
	 * Get all prices
	 * 
	 * @param pageNo Page number
	 * @param pageSize Number of prices by page
	 * @param sortBy  Attribute to sort
	 * 
	 * @return ResponseEntity<List<PriceDto>> 
	 */
	ResponseEntity<Page<PriceDto>> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy);

	/**
	 * @param pageNo    Page number
	 * @param pageSize  Number of prices by page
	 * @param sortBy    Attribute to sort
	 * @param date      Application date
	 * @param productId Product id
	 * @param barandId  Brand id
	 * 
	 * @return ResponseEntity<Page<PriceDateProductIdBrandId>>
	 */
	ResponseEntity<Page<PriceDateProductIdBrandIdDto>> getByDateIdProductIdBrand(Integer pageNo, Integer pageSize,
			String sortBy, String strDate, Long productId, Long brandId);

	/**
	 * Get All request headers
	 * 
	 * @param headers Request headers
	 * 
	 * @return ResponseEntity<Map<String, String>>
	 */
	ResponseEntity<Map<String, String>> listAllHeaders(Map<String, String> headers);

}