package br.com.leomanzini.dollar.price.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
