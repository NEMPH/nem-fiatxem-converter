package io.nem.apps.adapters;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map.Entry;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import io.nem.apps.model.FiatXem;
import io.nem.apps.model.FiatsXem;
import io.nem.apps.model.Price;
import io.nem.apps.model.XemFiat;

public class FiatsXemDeserializer implements JsonDeserializer<FiatsXem> {

	@Override
	public FiatsXem deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		
		FiatsXem fiatsXem = new FiatsXem();
		Iterator<Entry<String,JsonElement>> iter = arg0.getAsJsonObject().entrySet().iterator();
		while(iter.hasNext()) {
			FiatXem fiatXem = new FiatXem();
			Price price = new Price();
			Entry<String,JsonElement> entry = iter.next();
			fiatXem.setParentSymbol(entry.getKey());
			price.setCurrencySymbol("XEM");
			price.setPrice(entry.getValue().getAsJsonObject().get("XEM").getAsBigDecimal());
			fiatXem.addChildPrice(price);
			
			fiatsXem.addFiatXem(fiatXem);
		}
		
		return fiatsXem;
	}

}
