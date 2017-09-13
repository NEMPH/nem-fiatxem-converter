package io.nem.apps.adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import io.nem.apps.model.Price;


/**
 * The Class PriceDeserializer.
 */
public class PriceDeserializer implements JsonDeserializer<Price> {

	/* (non-Javadoc)
	 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	@Override
	public Price deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		Price price = new Price();
		if (arg0.toString().contains("XEM")) {
			price.setCurrencySymbol("XEM");
			price.setPrice(arg0.getAsJsonObject().get("XEM").getAsBigDecimal());
		} else {
			String keySymbol = arg0.getAsJsonObject().entrySet().stream().findFirst().orElse(null).getKey();
			price.setCurrencySymbol(keySymbol);
			price.setPrice(arg0.getAsJsonObject().get(keySymbol).getAsBigDecimal());
		}
		return price;
	}

}
