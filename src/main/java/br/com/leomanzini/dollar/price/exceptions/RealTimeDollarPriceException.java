package br.com.leomanzini.dollar.price.exceptions;

public class RealTimeDollarPriceException extends Exception {

	private static final long serialVersionUID = 94783155928792070L;
	
	private int errorCode;
	
	public RealTimeDollarPriceException(int errorCode) {
		this.errorCode = errorCode;
	}
	
	@Override
	public String toString() {
		return "ERROR: While processing real time dollar, code: " + errorCode;
	}
}
