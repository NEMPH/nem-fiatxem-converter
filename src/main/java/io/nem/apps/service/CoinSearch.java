package io.nem.apps.service;

import java.util.concurrent.ExecutionException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.nem.apps.endpoint.api.EndPoints;
import io.nem.apps.endpoint.api.NetworkUtils;
import io.nem.apps.global.GlobalConfig;
import io.nem.apps.model.Coin;
import io.nem.apps.model.Coins;


/**
 * The Class CoinSearch.
 */
public class CoinSearch {

	/** The gson. */
	private static Gson gson = GlobalConfig.getInstance().getGson();

	/**
	 * Gets the all coins.
	 *
	 * @return the all coins
	 * @throws InterruptedException the interrupted exception
	 * @throws ExecutionException the execution exception
	 */
	public static Coins getAllCoins() throws InterruptedException, ExecutionException {

		JsonElement jElement = new JsonParser()
				.parse(NetworkUtils.getAsync(EndPoints.CC_COIN_LIST, "").get().getResponseBody()).getAsJsonObject()
				.get("Data");

		return gson.fromJson(jElement, Coins.class);
	}

	/**
	 * Search coin.
	 *
	 * @param symbol the symbol
	 * @return the coin
	 * @throws InterruptedException the interrupted exception
	 * @throws ExecutionException the execution exception
	 */
	public static Coin searchCoin(String symbol) throws InterruptedException, ExecutionException {
		return getAllCoins().getCoins().stream().filter(x -> symbol.equals(x.getName())).findFirst().orElse(null);
	}
}
