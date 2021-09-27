package br.com.leomanzini.dollar.price.service;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leomanzini.dollar.price.dto.DollarResponse;

public interface DollarPriceRepository extends JpaRepository<DollarResponse, Long> {

}
