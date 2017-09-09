package io.nem.apps.converter;

import java.util.concurrent.ExecutionException;
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

		IBuild applyFees(Double fees);

		Double ToXem();
	}

	public interface IToFiat {

		IBuild applyFees(Double fees);

		Double ToFiat(String symbol);
	}

	public interface IBuild {
		Double compute();
	}

	private static class Builder implements IToXem, IToFiat, IBuild {

		private String fiatSymbol = "";
		private Double fiatAmount = 0d;
		private Double fees;
		private Double xem = 0d;
		private Double computedPrice = 0d;

		public Builder(String symbol, Double fiatAmount) {
			this.fiatAmount = fiatAmount;
			this.fiatSymbol = symbol;
		}

		public Builder(String symbol, String fiatAmount) {
			this.fiatAmount = Double.valueOf(fiatAmount);
			this.fiatSymbol = symbol;
		}

		public Builder(Double xemAmount) {
			this.xem = xemAmount;
		}

		public Builder(String xemAmount) {
			this.xem = Double.valueOf(xemAmount);
		}

		@Override
		public IBuild applyFees(Double fees) {
			this.fees = fees;
			return this;
		}

		@Override
		public Double compute() {
			try {
				this.computedPrice = PriceCompute.getFiatToXem(this.fiatSymbol, String.valueOf(this.fiatAmount));
				return computedPrice;
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public Double ToXem() {
			return this.compute();
		}

		@Override
		public Double ToFiat(String symbol) {
			try {
				this.computedPrice = PriceCompute.getXemToFiat(symbol, String.valueOf(this.xem));
				return computedPrice;
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			return null;
		}

	}

}
