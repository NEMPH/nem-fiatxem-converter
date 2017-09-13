package io.nem.apps.adapters;

import java.lang.reflect.Type;	
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import io.nem.apps.model.Coin;
import io.nem.apps.model.Coins;


/**
 * The Class CoinsDeserializer.
 */
public class CoinsDeserializer implements JsonDeserializer<Coins> {

	/** The gson. */
	private static Gson gson = new Gson();

	/* (non-Javadoc)
	 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	@Override
	public Coins deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		Coins coins = new Coins();

		arg0.getAsJsonObject().entrySet().forEach(entry -> {
			coins.addCoin(CoinsDeserializer.gson.fromJson(entry.getValue(), Coin.class));
		});

		return coins;
	}

}
