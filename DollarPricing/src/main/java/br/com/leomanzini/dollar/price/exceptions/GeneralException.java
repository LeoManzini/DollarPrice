package br.com.leomanzini.dollar.price.exceptions;

public class GeneralException extends Exception {

	private static final long serialVersionUID = 94783155928792070L;
	
	@Override
	public String toString() {
		return "ERROR: Something went wrong with the requisition. ";
	}
}
