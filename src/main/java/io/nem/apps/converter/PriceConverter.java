package io.nem.apps.converter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

import io.nem.apps.model.FiatsXem;
import io.nem.apps.model.XemFiat;
import io.nem.apps.service.PriceCompute;

public class PriceConverter {

	private PriceConverter() {
	}

	public static IToXem fromFiat(String symbol, Double fiatAmount) {
		return new PriceConverter.Builder(symbol, fiatAmount);
	}

	public static IToFiat fromXem(String xemAmount) {
		return new PriceConverter.Builder(xemAmount);
	}

	public static IToXem fromFiat(String symbol, String fiatAmount) {
		return new PriceConverter.Builder(symbol, fiatAmount);
	}

	public static IToFiat fromXem(Double xemAmount) {
		return new PriceConverter.Builder(xemAmount);
	}

	public interface IToXem {

		IToXem fromFiat(String symbol, String fiatAmount);

		IToXem fromFiat(String symbol, Double fiatAmount);

		IToXem fromFiat(String symbol);

		FiatsXem toXem();

	}

	public interface IToFiat {

		IToFiat toFiat(String symbol);

		 XemFiat convert();
	}

	private static class Builder implements IToXem, IToFiat {

		private String fiatSymbol = "";
		private Double fiatAmount = 0d;
		private Double fees;
		private Double xem = 0d;
		private Double computedPrice = 0d;
		private ConcurrentHashMap<String, String> conversionKv = new ConcurrentHashMap<String, String>();

		public Builder(String symbol, Double fiatAmount) {
			this.conversionKv.put(symbol, String.valueOf(fiatAmount));;
		}

		public Builder(String symbol, String fiatAmount) {
			this.conversionKv.put(symbol, fiatAmount);
		}

		public Builder(Double xemAmount) {
			this.xem = xemAmount;
		}

		public Builder(String xemAmount) {
			this.xem = Double.valueOf(xemAmount);
		}

		@Override
		public IToFiat toFiat(String symbol) {
			this.conversionKv.put(symbol, "1.0");
			return this;
		}

		@Override
		public IToXem fromFiat(String symbol) {
			this.conversionKv.put(symbol, "1.0");
			return this;
		}

		@Override
		public IToXem fromFiat(String symbol, String fiatAmount) {
			this.conversionKv.put(symbol, fiatAmount);
			return this;
		}

		@Override
		public IToXem fromFiat(String symbol, Double fiatAmount) {
			this.conversionKv.put(symbol, String.valueOf(fiatAmount));
			return this;
		}

		@Override
		public  XemFiat convert() {
			try {
				return PriceCompute.getXemToFiats(this.xem,this.conversionKv);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public FiatsXem toXem() {
			try {
				return PriceCompute.getFiatsToXem(this.conversionKv);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			return null;
		}

	}

}
