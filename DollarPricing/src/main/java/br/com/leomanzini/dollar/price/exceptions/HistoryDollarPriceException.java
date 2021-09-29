package br.com.leomanzini.dollar.price.exceptions;

public class HistoryDollarPriceException extends Exception {

	private static final long serialVersionUID = 94783155928792070L;
	
	private int errorCode;
	
	public HistoryDollarPriceException(int errorCode) {
		this.errorCode = errorCode;
	}
	
	@Override
	public String toString() {
		return "ERROR: While processing history dollar, code: " + errorCode;
	}
}
