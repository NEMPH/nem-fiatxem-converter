package io.nem.apps.converter;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class PriceConverterTest {

	@Test
	public void testConvertToXem() {
		assertNotNull(PriceConverter.fromFiat("CAD", 2.00).fromFiat("USD", 2.00).toXem().getXemPriceFor("USD"));
	}

	@Test
	public void testConvertToFiat() {
		assertNotNull(PriceConverter.fromXem(2.00).toFiat("USD").toFiat("PHP").convert().getPriceOf("PHP"));
	}

}
