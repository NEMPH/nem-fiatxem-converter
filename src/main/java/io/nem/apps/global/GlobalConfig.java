package io.nem.apps.global;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.nem.apps.adapters.CoinsDeserializer;
import io.nem.apps.adapters.PriceDeserializer;
import io.nem.apps.model.Coins;
import io.nem.apps.model.Price;

public class GlobalConfig {
	private static Gson gson = null;
	private static GlobalConfig instance;
	
	public static GlobalConfig getInstance() {
		if(instance == null) 
			instance = new GlobalConfig();
		return instance;
	}
	private GlobalConfig() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(Coins.class, new CoinsDeserializer());
		gsonBuilder.registerTypeAdapter(Price.class, new PriceDeserializer());
		gson = gsonBuilder.create();
	}
	
	public Gson getGson() {
		return gson;
	}

}
