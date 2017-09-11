package io.nem.apps.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class XemFiat {

	private String parentSymbol;
	private Double parentPrice;

	private List<Price> fiatPrices = new ArrayList<Price>();

	public String getParentSymbol() {
		return parentSymbol;
	}

	public void setParentSymbol(String parentSymbol) {
		this.parentSymbol = parentSymbol;
	}

	public Double getParentPrice() {
		return parentPrice;
	}

	public void setParentPrice(Double parentPrice) {
		this.parentPrice = parentPrice;
	}

	public List<Price> getFiatPrices() {
		return fiatPrices;
	}

	public void setFiatPrices(List<Price> fiatPrices) {
		this.fiatPrices = fiatPrices;
	}
	
	public void addChildPrice(Price price) {
		this.fiatPrices.add(price);
	}
	
	public BigDecimal getPriceOf(String symbol) {
		return this.getFiatPrices().stream().filter(d -> symbol.equals(d.getCurrencySymbol())).findFirst().orElse(null).getPrice();
	}

}
