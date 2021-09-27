package com.company.ms_products.services;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.ms_products.dto.PriceDateProductIdBrandIdDto;
import com.company.ms_products.dto.PriceDto;
import com.company.ms_products.entities.Price;
import com.company.ms_products.repositories.PriceRepository;

/**
 * Price Service Class. Here is implemented business logic
 * 
 * @author Miguel Pedraz Hernandez
 * @version 0.1
 *
 */
@Service
public class PriceServiceImpl implements PriceService {
	private final PriceRepository priceRepository;

	/**
	 * Constructor
	 * 
	 * @param priceRepository Repository
	 */
	public PriceServiceImpl(PriceRepository priceRepository) {
		this.priceRepository = priceRepository;
	}

	
	@Override
	@Transactional(readOnly = true)
	public Page<PriceDto> getAllPrices(Integer pageNo, Integer pageSize, String sortBy) {

		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Price> pagedResult = priceRepository.findAll(paging);
		
		Page<PriceDto> pPricedto = pagedResult.map(this::priceEntityToDto);

		return pPricedto;
	

	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<PriceDateProductIdBrandIdDto> getByDateIdProductIdBrand(Integer pageNo, 
			Integer pageSize, String sortBy, LocalDateTime date, Long productId, 
			Long brandId) {
		
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		
		Page<Price> pagedResult = priceRepository.findByDateIdProductIdBrand(
				paging,Timestamp.valueOf(date), productId, brandId);
		
		Page<PriceDateProductIdBrandIdDto> pPricedto = pagedResult.map(this::priceDateProductIdBrandIdEntityToDto);
		
		return pPricedto;
		
		
	}

	/**
	 * Method to convert entity to dto
	 * 
	 * @param item Entity to convert
	 * 
	 * @return PriceDto
	 */
	private PriceDto priceEntityToDto(Price item) {
		return new PriceDto(item.getId(),
				item.getStartDate().toInstant().atZone(ZoneId.of("Europe/Madrid")).toLocalDateTime(),
				item.getEndDate().toInstant().atZone(ZoneId.of("Europe/Madrid")).toLocalDateTime(), 
				item.getPriority(),item.getPrice(),item.getCurr(),
				item.getBrandId(),item.getProductId());
	}
	
	/**
	 * Method to convert entity to dto
	 * 
	 * @param item Entity to convert
	 * 
	 * @return PriceDto
	 */
	private PriceDateProductIdBrandIdDto priceDateProductIdBrandIdEntityToDto(Price item) {
		return new PriceDateProductIdBrandIdDto(item.getProductId(),item.getBrandId(),item.getId(),
				item.getStartDate().toInstant().atZone(ZoneId.of("Europe/Madrid")).toLocalDateTime(),
				item.getEndDate().toInstant().atZone(ZoneId.of("Europe/Madrid")).toLocalDateTime(), 
				item.getPrice());
	}

}
