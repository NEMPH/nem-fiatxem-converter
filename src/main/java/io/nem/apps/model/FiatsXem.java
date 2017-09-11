package io.nem.apps.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class FiatsXem {
	
	private List<FiatXem> fiatXems = new ArrayList<FiatXem>();

	public List<FiatXem> getFiatXems() {
		return fiatXems;
	}

	public void setFiatXems(List<FiatXem> fiatXems) {
		this.fiatXems = fiatXems;
	}

	public void addFiatXem(FiatXem fx) {
		this.fiatXems.add(fx);
	}
	
	public BigDecimal getXemPriceFor(String symbol) {
		FiatXem price =  this.fiatXems.stream().filter(d -> symbol.equals(d.getParentSymbol())).findFirst().orElse(null);
		return price.getFiatPrices().get(0).getPrice();
	}
}
