package io.nem.apps.converter;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

import io.nem.apps.service.PriceCompute;

public class PriceConverterTest {

	@Test
	public void testConvertToXem() {

		assertNotNull(PriceConverter.fromFiat("CAD", 2.0).fromFiat("USD", 2.0).toXem().getXemPriceFor("USD"));
	}

	@Test
	public void testConvertToCad() {
		assertNotNull(PriceConverter.fromXem(2.0).toFiat("USD").toFiat("PHP").convert().getPriceOf("PHP"));

	}

}
