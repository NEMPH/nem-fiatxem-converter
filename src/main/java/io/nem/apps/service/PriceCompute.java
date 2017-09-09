package io.nem.apps.service;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import io.nem.apps.endpoint.api.EndPoints;
import io.nem.apps.endpoint.api.NetworkUtils;
import io.nem.apps.global.GlobalConfig;
import io.nem.apps.model.Coins;
import io.nem.apps.model.Price;

public class PriceCompute {

	private static Gson gson = GlobalConfig.getInstance().getGson();

	public static Double getFiatToXem(String fiatSymbol,String fiatAmount) throws InterruptedException, ExecutionException {

		JsonElement jElement = new JsonParser()
				.parse(NetworkUtils.getAsync(EndPoints.CC_FIAT_TO_XEM, "?fsym=" + fiatSymbol + "&tsyms=XEM").get().getResponseBody());

		Price price = gson.fromJson(jElement, Price.class);

		return (BigDecimal.valueOf(Double.valueOf(fiatAmount)).multiply(price.getPrice())).doubleValue();

	}

	public static Double getXemToFiat(String fiatSymbol,String fiatAmount) throws InterruptedException, ExecutionException {

		JsonElement jElement = new JsonParser()
				.parse(NetworkUtils.getAsync(EndPoints.CC_XEM_TO_FIAT, "?fsym=XEM&tsyms=" + fiatSymbol).get().getResponseBody());

		Price price = gson.fromJson(jElement, Price.class);

		return (BigDecimal.valueOf(Double.valueOf(fiatAmount)).multiply(price.getPrice())).doubleValue();

	}
}
