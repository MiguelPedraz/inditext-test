package com.company.ms_products.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.ms_products.dto.PriceDateProductIdBrandIdDto;
import com.company.ms_products.dto.PriceDto;
import com.company.ms_products.services.PriceService;

/**
 * Price Controller Class. 
 * Here is implemented rest interface
 * 
 * @author Miguel Pedraz Hernandez
 * @version 0.1
 *
 */
@RestController
@RequestMapping(value = "/prices", produces = "application/hal+json")
public class PriceControllerImpl implements PriceController {

	private final PriceService priceService;
	
	
	/**
	 * Constructor 
	 * 
	 * @param priceService Service
	 */
	public PriceControllerImpl(PriceService priceService) {
		super();
		this.priceService = priceService;
	}


	
	@Override
	@GetMapping
	public ResponseEntity<Page<PriceDto>> getAllPrices(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "id") String sortBy) {
		Page<PriceDto> pPriceDto = priceService.getAllPrices(pageNo, pageSize, sortBy);
		return new ResponseEntity<Page<PriceDto> >(pPriceDto, HttpStatus.OK);
	}
	
	
	@Override
	@GetMapping(value = "/date-productid-brandid")
	public ResponseEntity<Page<PriceDateProductIdBrandIdDto>> getPriceByDateIdProductIdBrand(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(value = "date", required = false) String strDate, 
			@RequestParam(value = "productId", required = false) Long productId, 
			@RequestParam(value = "brandId", required = false) Long brandId ) {
		
		String str = strDate; 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss"); 
		LocalDateTime date = LocalDateTime.parse(str, formatter);

		Page<PriceDateProductIdBrandIdDto> pPriceDto = priceService.getPriceByDateIdProductIdBrand(pageNo,
				pageSize, sortBy, date, productId, brandId);
		return new ResponseEntity<Page<PriceDateProductIdBrandIdDto> >(pPriceDto, HttpStatus.OK);
	}
	
	
	@Override
	@GetMapping(value = "/headers")
	public ResponseEntity<Map<String, String>> listAllHeaders(@RequestHeader Map<String, String> headers) {
		
		Map<String,String> lsHeaders = new HashMap<String,String>();
		
		headers.forEach((key, value) -> {
			lsHeaders.put(key, value);
		});

		return new ResponseEntity<Map<String,String>>(lsHeaders, HttpStatus.OK);
	}

}
