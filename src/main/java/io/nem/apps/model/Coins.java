package io.nem.apps.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;


/**
 * The Class Coins.
 */
public class Coins implements Serializable {

	/** The coins. */
	private List<Coin> coins = new ArrayList<Coin>();

	/**
	 * Gets the coins.
	 *
	 * @return the coins
	 */
	public List<Coin> getCoins() {
		return coins;
	}

	/**
	 * Sets the coins.
	 *
	 * @param coins the new coins
	 */
	public void setCoins(List<Coin> coins) {
		this.coins = coins;
	}

	/**
	 * Adds the coin.
	 *
	 * @param coin the coin
	 */
	public void addCoin(Coin coin) {
		this.coins.add(coin);
	}

}
