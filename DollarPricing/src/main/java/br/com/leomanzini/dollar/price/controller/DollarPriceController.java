package br.com.leomanzini.dollar.price.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.leomanzini.dollar.price.dto.response.HistoryDollarResponse;
import br.com.leomanzini.dollar.price.dto.response.RealTimeDollarResponse;
import br.com.leomanzini.dollar.price.service.DollarPriceService;

@RestController
@RequestMapping("/price")
public class DollarPriceController {

	@Autowired
	private DollarPriceService dollarService;

	@GetMapping
	public RealTimeDollarResponse getRealTimeDollarPrice() throws Exception {
		return dollarService.getRealTimeDollarPrice();
	}

	@GetMapping("/{day}/{month}/{year}")
	public List<HistoryDollarResponse> getHistoryDollarPrice(@PathVariable(value = "day") String day,
			@PathVariable(value = "month") String month, @PathVariable(value = "year") String year) throws Exception {
		return dollarService.getHistoryDollarPrice(day,month,year);
	}
}
