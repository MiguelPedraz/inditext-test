package com.company.ms_products.repositories;

import java.sql.Timestamp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.company.ms_products.entities.Price;

/**
 * Price Repository interface  in JPA
 * Here is implemented database access
 * 
 * @author Miguel Pedraz Hernandez
 * @version 0.1
 *
 */
@Repository
public interface PriceRepository extends PagingAndSortingRepository<Price, Long> {

//	Page<Price> findAll(Pageable pageable);
	
	/**
	 * @param pageable
	 * @param date
	 * @param productId
	 * @param barandId
	 * @return
	 */
	@Query(   "SELECT p "
			+ "FROM Price p "
			+ "WHERE p.startDate < :date "
			+ "AND p.endDate > :date "
			+ "AND p.productId = :productId "
			+ "AND p.brandId = :brandId "
			+ "AND p.priority IN ("
			+ "	 SELECT MAX(p.priority)"
			+ "  FROM Price p"
			+ "  WHERE p.startDate < :date "
			+ "  AND p.endDate > :date "
			+ "  AND p.productId = :productId "
			+ "  AND p.brandId = :brandId "
			+ ")"
		   )
	Page<Price> findByDateIdProductIdBrand(Pageable pageable, 
			@Param("date")Timestamp date, @Param("productId")Long productId, 
			@Param("brandId")Long barandId);
}
