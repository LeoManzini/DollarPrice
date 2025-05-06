package br.com.leomanzini.dollar.price.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReturnCodes {
	
	CONSULT_SUCCESS(200),
	RETURN_SUCCESS(0),
	RETURN_REAL_TIME_ERROR(-1),
	RETURN_HISTORY_ERROR(-2);
	
	private int code;
}
