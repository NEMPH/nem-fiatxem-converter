package io.nem.apps.endpoint.api;


/**
 * The Enum EndPoints.
 */
public enum EndPoints {

	/** The cc coin list. */
	CC_COIN_LIST("https://www.cryptocompare.com/api/data/coinlist/"),
	
	/** The cc conv single. */
	CC_CONV_SINGLE("https://min-api.cryptocompare.com/data/price"),
	
	/** The cc conv multi. */
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
