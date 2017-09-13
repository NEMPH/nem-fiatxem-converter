package io.nem.apps.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;


/**
 * The Class Coin.
 */
public class Coin implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	@SerializedName("Id")
	private String id;
	
	/** The url. */
	@SerializedName("Url")
	private String url;
	
	/** The image url. */
	@SerializedName("ImageUrl")
	private String imageUrl;
	
	/** The name. */
	@SerializedName("Name")
	private String name;
	
	/** The coin name. */
	@SerializedName("CoinName")
	private String coinName;
	
	/** The full name. */
	@SerializedName("FullName")
	private String fullName;
	
	/** The algorithm. */
	@SerializedName("Algorithm")
	private String algorithm;
	
	/** The proof type. */
	@SerializedName("ProofType")
	private String proofType;
	
	/** The fully premined. */
	@SerializedName("FullyPremined")
	private String fullyPremined;
	
	/** The total coin supply. */
	@SerializedName("TotalCoinSupply")
	private String totalCoinSupply;
	
	/** The pre mined value. */
	@SerializedName("PreMinedValue")
	private String preMinedValue;
	
	/** The total coins free float. */
	@SerializedName("TotalCoinsFreeFloat")
	private String totalCoinsFreeFloat;
	
	/** The sort order. */
	@SerializedName("SortOrder")
	private String sortOrder;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Gets the image url.
	 *
	 * @return the image url
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * Sets the image url.
	 *
	 * @param imageUrl the new image url
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the coin name.
	 *
	 * @return the coin name
	 */
	public String getCoinName() {
		return coinName;
	}

	/**
	 * Sets the coin name.
	 *
	 * @param coinName the new coin name
	 */
	public void setCoinName(String coinName) {
		this.coinName = coinName;
	}

	/**
	 * Gets the full name.
	 *
	 * @return the full name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Sets the full name.
	 *
	 * @param fullName the new full name
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Gets the algorithm.
	 *
	 * @return the algorithm
	 */
	public String getAlgorithm() {
		return algorithm;
	}

	/**
	 * Sets the algorithm.
	 *
	 * @param algorithm the new algorithm
	 */
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

	/**
	 * Gets the proof type.
	 *
	 * @return the proof type
	 */
	public String getProofType() {
		return proofType;
	}

	/**
	 * Sets the proof type.
	 *
	 * @param proofType the new proof type
	 */
	public void setProofType(String proofType) {
		this.proofType = proofType;
	}

	/**
	 * Gets the fully premined.
	 *
	 * @return the fully premined
	 */
	public String getFullyPremined() {
		return fullyPremined;
	}

	/**
	 * Sets the fully premined.
	 *
	 * @param fullyPremined the new fully premined
	 */
	public void setFullyPremined(String fullyPremined) {
		this.fullyPremined = fullyPremined;
	}

	/**
	 * Gets the total coin supply.
	 *
	 * @return the total coin supply
	 */
	public String getTotalCoinSupply() {
		return totalCoinSupply;
	}

	/**
	 * Sets the total coin supply.
	 *
	 * @param totalCoinSupply the new total coin supply
	 */
	public void setTotalCoinSupply(String totalCoinSupply) {
		this.totalCoinSupply = totalCoinSupply;
	}

	/**
	 * Gets the pre mined value.
	 *
	 * @return the pre mined value
	 */
	public String getPreMinedValue() {
		return preMinedValue;
	}

	/**
	 * Sets the pre mined value.
	 *
	 * @param preMinedValue the new pre mined value
	 */
	public void setPreMinedValue(String preMinedValue) {
		this.preMinedValue = preMinedValue;
	}

	/**
	 * Gets the total coins free float.
	 *
	 * @return the total coins free float
	 */
	public String getTotalCoinsFreeFloat() {
		return totalCoinsFreeFloat;
	}

	/**
	 * Sets the total coins free float.
	 *
	 * @param totalCoinsFreeFloat the new total coins free float
	 */
	public void setTotalCoinsFreeFloat(String totalCoinsFreeFloat) {
		this.totalCoinsFreeFloat = totalCoinsFreeFloat;
	}

	/**
	 * Gets the sort order.
	 *
	 * @return the sort order
	 */
	public String getSortOrder() {
		return sortOrder;
	}

	/**
	 * Sets the sort order.
	 *
	 * @param sortOrder the new sort order
	 */
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.algorithm == null) ? 0 : this.algorithm.hashCode());
		result = prime * result + ((this.coinName == null) ? 0 : this.coinName.hashCode());
		result = prime * result + ((this.preMinedValue == null) ? 0 : this.preMinedValue.hashCode());
		return result;
	}
}
