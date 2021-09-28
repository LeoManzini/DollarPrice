package br.com.leomanzini.dollar.price.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDollarResponse {
	
	private String pctChange;
	private String bid;
	private String timestamp;
	private String create_date;
}
