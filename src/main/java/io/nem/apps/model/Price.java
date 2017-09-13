package io.nem.apps.model;

import java.math.BigDecimal;


/**
 * The Class Price.
 */
public class Price {
	
	/** The currency symbol. */
	private String currencySymbol;
	
	/** The price. */
	private BigDecimal price;
	
	/**
	 * Gets the currency symbol.
	 *
	 * @return the currency symbol
	 */
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	
	/**
	 * Sets the currency symbol.
	 *
	 * @param currencySymbol the new currency symbol
	 */
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	
	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}
