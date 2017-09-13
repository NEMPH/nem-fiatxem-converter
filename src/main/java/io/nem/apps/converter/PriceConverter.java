package io.nem.apps.converter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

import io.nem.apps.model.FiatsXem;
import io.nem.apps.model.XemFiat;
import io.nem.apps.service.PriceCompute;


/**
 * The Class PriceConverter.
 */
public class PriceConverter {

	/**
	 * Instantiates a new price converter.
	 */
	private PriceConverter() {
	}

	/**
	 * From fiat.
	 *
	 * @param symbol the symbol
	 * @param fiatAmount the fiat amount
	 * @return the i to xem
	 */
	public static IToXem fromFiat(String symbol, Double fiatAmount) {
		return new PriceConverter.Builder(symbol, fiatAmount);
	}

	/**
	 * From xem.
	 *
	 * @param xemAmount the xem amount
	 * @return the i to fiat
	 */
	public static IToFiat fromXem(String xemAmount) {
		return new PriceConverter.Builder(xemAmount);
	}

	/**
	 * From fiat.
	 *
	 * @param symbol the symbol
	 * @param fiatAmount the fiat amount
	 * @return the i to xem
	 */
	public static IToXem fromFiat(String symbol, String fiatAmount) {
		return new PriceConverter.Builder(symbol, fiatAmount);
	}

	/**
	 * From xem.
	 *
	 * @param xemAmount the xem amount
	 * @return the i to fiat
	 */
	public static IToFiat fromXem(Double xemAmount) {
		return new PriceConverter.Builder(xemAmount);
	}

	/**
	 * The Interface IToXem.
	 */
	public interface IToXem {

		/**
		 * From fiat.
		 *
		 * @param symbol the symbol
		 * @param fiatAmount the fiat amount
		 * @return the i to xem
		 */
		IToXem fromFiat(String symbol, String fiatAmount);

		/**
		 * From fiat.
		 *
		 * @param symbol the symbol
		 * @param fiatAmount the fiat amount
		 * @return the i to xem
		 */
		IToXem fromFiat(String symbol, Double fiatAmount);

		/**
		 * From fiat.
		 *
		 * @param symbol the symbol
		 * @return the i to xem
		 */
		IToXem fromFiat(String symbol);

		/**
		 * To xem.
		 *
		 * @return the fiats xem
		 */
		FiatsXem toXem();

	}

	/**
	 * The Interface IToFiat.
	 */
	public interface IToFiat {

		/**
		 * To fiat.
		 *
		 * @param symbol the symbol
		 * @return the i to fiat
		 */
		IToFiat toFiat(String symbol);

		 /**
 		 * Convert.
 		 *
 		 * @return the xem fiat
 		 */
 		XemFiat convert();
	}

	/**
	 * The Class Builder.
	 */
	private static class Builder implements IToXem, IToFiat {

		/** The fiat symbol. */
		private String fiatSymbol = "";
		
		/** The fiat amount. */
		private Double fiatAmount = 0d;
		
		/** The fees. */
		private Double fees;
		
		/** The xem. */
		private Double xem = 0d;
		
		/** The computed price. */
		private Double computedPrice = 0d;
		
		/** The conversion kv. */
		private ConcurrentHashMap<String, String> conversionKv = new ConcurrentHashMap<String, String>();

		/**
		 * Instantiates a new builder.
		 *
		 * @param symbol the symbol
		 * @param fiatAmount the fiat amount
		 */
		public Builder(String symbol, Double fiatAmount) {
			this.conversionKv.put(symbol, String.valueOf(fiatAmount));;
		}

		/**
		 * Instantiates a new builder.
		 *
		 * @param symbol the symbol
		 * @param fiatAmount the fiat amount
		 */
		public Builder(String symbol, String fiatAmount) {
			this.conversionKv.put(symbol, fiatAmount);
		}

		/**
		 * Instantiates a new builder.
		 *
		 * @param xemAmount the xem amount
		 */
		public Builder(Double xemAmount) {
			this.xem = xemAmount;
		}

		/**
		 * Instantiates a new builder.
		 *
		 * @param xemAmount the xem amount
		 */
		public Builder(String xemAmount) {
			this.xem = Double.valueOf(xemAmount);
		}

		/* (non-Javadoc)
		 * @see io.nem.apps.converter.PriceConverter.IToFiat#toFiat(java.lang.String)
		 */
		@Override
		public IToFiat toFiat(String symbol) {
			this.conversionKv.put(symbol, "1.0");
			return this;
		}

		/* (non-Javadoc)
		 * @see io.nem.apps.converter.PriceConverter.IToXem#fromFiat(java.lang.String)
		 */
		@Override
		public IToXem fromFiat(String symbol) {
			this.conversionKv.put(symbol, "1.0");
			return this;
		}

		/* (non-Javadoc)
		 * @see io.nem.apps.converter.PriceConverter.IToXem#fromFiat(java.lang.String, java.lang.String)
		 */
		@Override
		public IToXem fromFiat(String symbol, String fiatAmount) {
			this.conversionKv.put(symbol, fiatAmount);
			return this;
		}

		/* (non-Javadoc)
		 * @see io.nem.apps.converter.PriceConverter.IToXem#fromFiat(java.lang.String, java.lang.Double)
		 */
		@Override
		public IToXem fromFiat(String symbol, Double fiatAmount) {
			this.conversionKv.put(symbol, String.valueOf(fiatAmount));
			return this;
		}

		/* (non-Javadoc)
		 * @see io.nem.apps.converter.PriceConverter.IToFiat#convert()
		 */
		@Override
		public  XemFiat convert() {
			try {
				return PriceCompute.getXemToFiats(this.xem,this.conversionKv);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			return null;
		}

		/* (non-Javadoc)
		 * @see io.nem.apps.converter.PriceConverter.IToXem#toXem()
		 */
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
