package io.nem.apps.model;

import java.util.ArrayList;
import java.util.List;


/**
 * The Class FiatXem.
 */
public class FiatXem {

	/** The parent symbol. */
	private String parentSymbol;
	
	/** The parent price. */
	private Double parentPrice;

	/** The fiat prices. */
	private List<Price> fiatPrices = new ArrayList<Price>();

	/**
	 * Gets the parent symbol.
	 *
	 * @return the parent symbol
	 */
	public String getParentSymbol() {
		return parentSymbol;
	}

	/**
	 * Sets the parent symbol.
	 *
	 * @param parentSymbol the new parent symbol
	 */
	public void setParentSymbol(String parentSymbol) {
		this.parentSymbol = parentSymbol;
	}

	/**
	 * Gets the parent price.
	 *
	 * @return the parent price
	 */
	public Double getParentPrice() {
		return parentPrice;
	}

	/**
	 * Sets the parent price.
	 *
	 * @param parentPrice the new parent price
	 */
	public void setParentPrice(Double parentPrice) {
		this.parentPrice = parentPrice;
	}

	/**
	 * Gets the fiat prices.
	 *
	 * @return the fiat prices
	 */
	public List<Price> getFiatPrices() {
		return fiatPrices;
	}

	/**
	 * Sets the fiat prices.
	 *
	 * @param fiatPrices the new fiat prices
	 */
	public void setFiatPrices(List<Price> fiatPrices) {
		this.fiatPrices = fiatPrices;
	}
	
	/**
	 * Adds the child price.
	 *
	 * @param price the price
	 */
	public void addChildPrice(Price price) {
		this.fiatPrices.add(price);
	}

}
