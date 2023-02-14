package com.deb.microservices.currencyConversionservice;

import java.math.BigDecimal;

public class CurrencyConversion {
	
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionmultiple;
	private BigDecimal quantity;
	private BigDecimal totalClaculatedAmount;
	private String environment;
	
	public CurrencyConversion(Long id, String from, String to,BigDecimal quantity, BigDecimal conversionmultiple, 
			BigDecimal totalClaculatedAmount, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionmultiple = conversionmultiple;
		this.quantity = quantity;
		this.totalClaculatedAmount = totalClaculatedAmount;
		this.environment = environment;
	}

	public CurrencyConversion() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionmultiple() {
		return conversionmultiple;
	}

	public void setConversionmultiple(BigDecimal conversionmultiple) {
		this.conversionmultiple = conversionmultiple;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalClaculatedAmount() {
		return totalClaculatedAmount;
	}

	public void setTotalClaculatedAmount(BigDecimal totalClaculatedAmount) {
		this.totalClaculatedAmount = totalClaculatedAmount;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	
	

}
