package io.nem.apps.adapters;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map.Entry;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import io.nem.apps.model.Price;
import io.nem.apps.model.XemFiat;


/**
 * The Class XemFiatDeserializer.
 */
public class XemFiatDeserializer implements JsonDeserializer<XemFiat> {

	/* (non-Javadoc)
	 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	@Override
	public XemFiat deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		
		XemFiat xemFiat = new XemFiat();
		xemFiat.setParentSymbol("XEM");
		Iterator<Entry<String,JsonElement>> iter = arg0.getAsJsonObject().get("XEM").getAsJsonObject().entrySet().iterator();
		while(iter.hasNext()) {
			Price price = new Price();
			Entry<String,JsonElement> entry = iter.next();
			price.setCurrencySymbol(entry.getKey());
			price.setPrice(BigDecimal.valueOf(entry.getValue().getAsDouble()));
			xemFiat.addChildPrice(price);
		}
		
		return xemFiat;
	}

}
