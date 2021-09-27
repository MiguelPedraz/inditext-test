package com.company.ms_products.services_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;

import com.company.ms_products.dto.PriceDateProductIdBrandIdDto;
import com.company.ms_products.dto.PriceDto;
import com.company.ms_products.entities.Price;
import com.company.ms_products.repositories.PriceRepository;
import com.company.ms_products.services.PriceService;


/**
 * Price Service Test. Here is where doing the test of business logic
 * 
 * @author Miguel Pedraz Hernandez
 * @version 0.1
 *
 */
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yml")
public class PriceServiceTest {


	@Autowired
	private PriceRepository repository;

	@Autowired
	private PriceService service;

	@DisplayName("Test get all prices")
	@Test
	void testGetAllPrices() {
		Integer pageNo = 0;
		Integer pageSize = 10;
		String sortBy = "id";

		Page<PriceDto> priceServiceResult = service.getAllPrices(pageNo, pageSize, sortBy);

		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Price> pagedResult = repository.findAll(paging);

		Page<PriceDto> mockPricedto = pagedResult.map(this::PriceEntityToDto);

		assertEquals(mockPricedto.getContent().toString(), priceServiceResult.getContent().toString());
	}

	@DisplayName("Test of the date 2020-06-14 10:00:00")
	@Test
	void testGetByDateIdProductIdBrand1() {
		Integer pageNo = 0;
		Integer pageSize = 10;
		String sortBy = "id";

		String str = "2020-06-1410:00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss");
		LocalDateTime date = LocalDateTime.parse(str, formatter);

		Long productId = Long.valueOf(35455);
		Long brandId = Long.valueOf(1);

		Page<PriceDateProductIdBrandIdDto> priceServiceResult = service.getByDateIdProductIdBrand(pageNo, pageSize, sortBy,
				date, productId, brandId);

		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Price> pagedResult = repository.findByDateIdProductIdBrand(paging, Timestamp.valueOf(date), productId,
				brandId);

		Page<PriceDateProductIdBrandIdDto> mockPricedto = pagedResult.map(this::PriceDateProductIdBrandIdDtoEntityToDto);

		assertEquals(mockPricedto.getContent().toString(), priceServiceResult.getContent().toString());
	}

	@DisplayName("Test of the date 2020-06-14 16:00:00")
	@Test
	void testGetByDateIdProductIdBrand2() {
		Integer pageNo = 0;
		Integer pageSize = 10;
		String sortBy = "id";

		String str = "2020-06-1416:00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss");
		LocalDateTime date = LocalDateTime.parse(str, formatter);

		Long productId = Long.valueOf(35455);
		Long brandId = Long.valueOf(1);

		Page<PriceDateProductIdBrandIdDto> priceServiceResult = service.getByDateIdProductIdBrand(pageNo, pageSize, sortBy,
				date, productId, brandId);

		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Price> pagedResult = repository.findByDateIdProductIdBrand(paging, Timestamp.valueOf(date), productId,
				brandId);

		Page<PriceDateProductIdBrandIdDto> mockPricedto = pagedResult.map(this::PriceDateProductIdBrandIdDtoEntityToDto);

		assertEquals(mockPricedto.getContent().toString(), priceServiceResult.getContent().toString());
	}

	@DisplayName("Test of the date 2020-06-14 21:00:00")
	@Test
	void testGetByDateIdProductIdBrand3() {
		Integer pageNo = 0;
		Integer pageSize = 10;
		String sortBy = "id";

		String str = "2020-06-1421:00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss");
		LocalDateTime date = LocalDateTime.parse(str, formatter);

		Long productId = Long.valueOf(35455);
		Long brandId = Long.valueOf(1);

		Page<PriceDateProductIdBrandIdDto> priceServiceResult = service.getByDateIdProductIdBrand(pageNo, pageSize, sortBy,
				date, productId, brandId);

		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Price> pagedResult = repository.findByDateIdProductIdBrand(paging, Timestamp.valueOf(date), productId,
				brandId);

		Page<PriceDateProductIdBrandIdDto> mockPricedto = pagedResult.map(this::PriceDateProductIdBrandIdDtoEntityToDto);

		assertEquals(mockPricedto.getContent().toString(), priceServiceResult.getContent().toString());
	}

	@DisplayName("Test of the date 2020-06-15 10:00:00")
	@Test
	void testGetByDateIdProductIdBrand4() {
		Integer pageNo = 0;
		Integer pageSize = 10;
		String sortBy = "id";

		String str = "2020-06-1510:00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss");
		LocalDateTime date = LocalDateTime.parse(str, formatter);

		Long productId = Long.valueOf(35455);
		Long brandId = Long.valueOf(1);

		Page<PriceDateProductIdBrandIdDto> priceServiceResult = service.getByDateIdProductIdBrand(pageNo, pageSize, sortBy,
				date, productId, brandId);

		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Price> pagedResult = repository.findByDateIdProductIdBrand(paging, Timestamp.valueOf(date), productId,
				brandId);

		Page<PriceDateProductIdBrandIdDto> mockPricedto = pagedResult.map(this::PriceDateProductIdBrandIdDtoEntityToDto);

		assertEquals(mockPricedto.getContent().toString(), priceServiceResult.getContent().toString());
	}

	@DisplayName("Test of the date 2020-06-16 21:00:00")
	@Test
	void testGetByDateIdProductIdBrand5() {
		Integer pageNo = 0;
		Integer pageSize = 10;
		String sortBy = "id";

		String str = "2020-06-1621:00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss");
		LocalDateTime date = LocalDateTime.parse(str, formatter);

		Long productId = Long.valueOf(35455);
		Long brandId = Long.valueOf(1);

		Page<PriceDateProductIdBrandIdDto> priceServiceResult = service.getByDateIdProductIdBrand(pageNo, pageSize, sortBy,
				date, productId, brandId);

		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Price> pagedResult = repository.findByDateIdProductIdBrand(paging, Timestamp.valueOf(date), productId,
				brandId);

		Page<PriceDateProductIdBrandIdDto> mockPricedto = pagedResult.map(this::PriceDateProductIdBrandIdDtoEntityToDto);

		assertEquals(mockPricedto.getContent().toString(), priceServiceResult.getContent().toString());
	}

	/**
	 * Method to convert entity to dto
	 * 
	 * @param item Entity to convert
	 * 
	 * @return PriceDto
	 */
	private PriceDto PriceEntityToDto(Price item) {
		return new PriceDto(item.getId(),
				item.getStartDate().toInstant().atZone(ZoneId.of("Europe/Madrid")).toLocalDateTime(),
				item.getEndDate().toInstant().atZone(ZoneId.of("Europe/Madrid")).toLocalDateTime(), item.getPriority(),
				item.getPrice(), item.getCurr(), item.getBrandId(), item.getProductId());
	}

	/**
	 * Method to convert entity to dto
	 * 
	 * @param item Entity to convert
	 * 
	 * @return PriceDto
	 */
	private PriceDateProductIdBrandIdDto PriceDateProductIdBrandIdDtoEntityToDto(Price item) {
		return new PriceDateProductIdBrandIdDto(item.getProductId(), item.getBrandId(), item.getId(),
				item.getStartDate().toInstant().atZone(ZoneId.of("Europe/Madrid")).toLocalDateTime(),
				item.getEndDate().toInstant().atZone(ZoneId.of("Europe/Madrid")).toLocalDateTime(), item.getPrice());
	}

}
