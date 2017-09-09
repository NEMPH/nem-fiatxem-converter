package io.nem.apps.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Coins implements Serializable {

	private List<Coin> coins = new ArrayList<Coin>();

	public List<Coin> getCoins() {
		return coins;
	}

	public void setCoins(List<Coin> coins) {
		this.coins = coins;
	}

	public void addCoin(Coin coin) {
		this.coins.add(coin);
	}

}
