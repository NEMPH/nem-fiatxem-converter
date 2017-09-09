package io.nem.apps.converter;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class PriceConverterTest {

	@Test
	public void testConvertToXem() {
		Double toXem = PriceConverter.fromFiat("CAD", "1.0").ToXem();
		
		assertNotNull(toXem);
	}
	
	@Test
	public void testConvertToCad() {
		Double toCad = PriceConverter.fromXem("2").ToFiat("CAD");
		
		assertNotNull(toCad);
	}

}
