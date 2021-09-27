package br.com.leomanzini.dollar.price.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DollarResponse {
	
	private String name;
	private Long bid;
	private String timestamp;
	private LocalDateTime createDate;
}
