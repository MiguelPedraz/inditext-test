package com.company.ms_products.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Price Date ProductId BrandId Dto
 * 
 * @author Miguel Pedraz Hernandez
 * @version 0.1
 *
 */
public class PriceDateProductIdBrandIdDto implements Serializable {


	private static final long serialVersionUID = 2428731275852802845L;
	
	private Long productId;
	private Long brandId;
	private Long priceList;
	private LocalDateTime startDate; 
	private LocalDateTime endDate; 
	private BigDecimal price;
	
	
	/**
	 * Constructor
	 * 
	 * @param productId Product id
	 * @param brandId Brand chain id
	 * @param priceList Id of  applicable prices  rate
	 * @param startDate Start date of price 
	 * @param endDate End date of price 
	 * @param price Price 
	 */
	public PriceDateProductIdBrandIdDto(Long productId, Long brandId, Long priceList,
			LocalDateTime startDate, LocalDateTime endDate, BigDecimal price) {
		super();
		this.productId = productId;
		this.brandId = brandId;
		this.priceList = priceList;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
	}


	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}


	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}


	/**
	 * @return the brandId
	 */
	public Long getBrandId() {
		return brandId;
	}


	/**
	 * @param brandId the brandId to set
	 */
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}


	/**
	 * @return the priceList
	 */
	public Long getPriceList() {
		return priceList;
	}


	/**
	 * @param priceList the priceList to set
	 */
	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}


	/**
	 * @return the startDate
	 */
	public LocalDateTime getStartDate() {
		return startDate;
	}


	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}


	/**
	 * @return the endDate
	 */
	public LocalDateTime getEndDate() {
		return endDate;
	}


	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}


	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brandId == null) ? 0 : brandId.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((priceList == null) ? 0 : priceList.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriceDateProductIdBrandIdDto other = (PriceDateProductIdBrandIdDto) obj;
		if (brandId == null) {
			if (other.brandId != null)
				return false;
		} else if (!brandId.equals(other.brandId))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (priceList == null) {
			if (other.priceList != null)
				return false;
		} else if (!priceList.equals(other.priceList))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "PriceDateProductIdBrandId [productId=" + productId + ", brandId=" + brandId + ", priceList=" + priceList
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", price=" + price + "]";
	}
	
	
}
