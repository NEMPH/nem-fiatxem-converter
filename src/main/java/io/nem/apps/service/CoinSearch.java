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

public class CoinSearch {

	private static Gson gson = GlobalConfig.getInstance().getGson();

	public static Coins getAllCoins() throws InterruptedException, ExecutionException {

		JsonElement jElement = new JsonParser()
				.parse(NetworkUtils.getAsync(EndPoints.CC_COIN_LIST, "").get().getResponseBody()).getAsJsonObject()
				.get("Data");

		return gson.fromJson(jElement, Coins.class);
	}

	public static Coin searchCoin(String symbol) throws InterruptedException, ExecutionException {
		return getAllCoins().getCoins().stream().filter(x -> symbol.equals(x.getName())).findFirst().orElse(null);
	}
}
