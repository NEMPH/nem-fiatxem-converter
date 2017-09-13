package io.nem.apps.service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.nem.apps.endpoint.api.EndPoints;
import io.nem.apps.endpoint.api.NetworkUtils;
import io.nem.apps.global.GlobalConfig;
import io.nem.apps.model.FiatXem;
import io.nem.apps.model.FiatsXem;
import io.nem.apps.model.Price;
import io.nem.apps.model.XemFiat;


/**
 * The Class PriceCompute.
 */
public class PriceCompute {

	/** The gson. */
	private static Gson gson = GlobalConfig.getInstance().getGson();

	/**
	 * Gets the fiat to xem.
	 *
	 * @param fiatSymbol the fiat symbol
	 * @param fiatAmount the fiat amount
	 * @return the fiat to xem
	 * @throws InterruptedException the interrupted exception
	 * @throws ExecutionException the execution exception
	 */
	public static Double getFiatToXem(String fiatSymbol, String fiatAmount)
			throws InterruptedException, ExecutionException {

		JsonElement jElement = new JsonParser().parse(NetworkUtils
				.getAsync(EndPoints.CC_CONV_SINGLE, "?fsym=" + fiatSymbol + "&tsyms=XEM").get().getResponseBody());

		Price price = gson.fromJson(jElement, Price.class);

		return (BigDecimal.valueOf(Double.valueOf(fiatAmount)).multiply(price.getPrice())).doubleValue();

	}

	/**
	 * Gets the fiats to xem.
	 *
	 * @param conversionKv the conversion kv
	 * @return the fiats to xem
	 * @throws InterruptedException the interrupted exception
	 * @throws ExecutionException the execution exception
	 */
	public static FiatsXem getFiatsToXem(Map<String, String> conversionKv) throws InterruptedException, ExecutionException {

		String multipleSym = "";

		for (String s : conversionKv.keySet()) {
			multipleSym += s + ",";
		}
		multipleSym = multipleSym.substring(0, multipleSym.length() - 1);

		JsonElement jElement = new JsonParser().parse(NetworkUtils
				.getAsync(EndPoints.CC_CONV_MULTI, "?fsyms=" + multipleSym + "&tsyms=XEM").get().getResponseBody());

		FiatsXem fiatsXem = gson.fromJson(jElement, FiatsXem.class);
		for(FiatXem ftx:fiatsXem.getFiatXems()) {
			for(Price childPrice:ftx.getFiatPrices()) {
				childPrice.setPrice(BigDecimal.valueOf(Double.valueOf(conversionKv.get(ftx.getParentSymbol()))).multiply(childPrice.getPrice()));
			}
		}
		
		return fiatsXem;

	}

	/**
	 * Gets the xem to fiats.
	 *
	 * @param xem the xem
	 * @param conversionKv the conversion kv
	 * @return the xem to fiats
	 * @throws InterruptedException the interrupted exception
	 * @throws ExecutionException the execution exception
	 */
	public static XemFiat getXemToFiats(Double xem, Map<String, String> conversionKv)
			throws InterruptedException, ExecutionException {

		String multipleSym = "";

		for (String s : conversionKv.keySet()) {
			multipleSym += s + ",";
		}
		multipleSym = multipleSym.substring(0, multipleSym.length() - 1);

		JsonElement jElement = new JsonParser().parse(NetworkUtils
				.getAsync(EndPoints.CC_CONV_MULTI, "?fsyms=XEM&tsyms=" + multipleSym).get().getResponseBody());

		XemFiat xemFiat = gson.fromJson(jElement, XemFiat.class);
		for(Price childPrice:xemFiat.getFiatPrices()) {
			childPrice.setPrice(BigDecimal.valueOf(xem).multiply(childPrice.getPrice()));
		}


		return xemFiat;

	}

	/**
	 * Gets the xem to fiat.
	 *
	 * @param fiatSymbol the fiat symbol
	 * @param fiatAmount the fiat amount
	 * @return the xem to fiat
	 * @throws InterruptedException the interrupted exception
	 * @throws ExecutionException the execution exception
	 */
	public static Double getXemToFiat(String fiatSymbol, String fiatAmount)
			throws InterruptedException, ExecutionException {

		JsonElement jElement = new JsonParser().parse(NetworkUtils
				.getAsync(EndPoints.CC_CONV_SINGLE, "?fsym=XEM&tsyms=" + fiatSymbol).get().getResponseBody());

		Price price = gson.fromJson(jElement, Price.class);

		return (BigDecimal.valueOf(Double.valueOf(fiatAmount)).multiply(price.getPrice())).doubleValue();

	}
}
