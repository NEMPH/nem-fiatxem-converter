package io.nem.apps.endpoint.api;

public enum EndPoints {

	CC_COIN_LIST("https://www.cryptocompare.com/api/data/coinlist/"),
	CC_CONV_SINGLE("https://min-api.cryptocompare.com/data/price"),
	CC_CONV_MULTI("https://min-api.cryptocompare.com/data/pricemulti");
	
	/** The value. */
	private final String value;

	/**
	 * Creates a NIS API id.
	 *
	 * @param value The string representation.
	 */
	EndPoints(final String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.value;
	}
}
