package br.com.leomanzini.dollar.price.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leomanzini.dollar.price.dto.DollarResponse;

@Service
public class DollarPriceService {
	
	@Autowired
	private DollarPriceRepository dollarRepository;
	
	public DollarResponse getPrice(Long id) {
		return dollarRepository.getById(id);
	}
}
