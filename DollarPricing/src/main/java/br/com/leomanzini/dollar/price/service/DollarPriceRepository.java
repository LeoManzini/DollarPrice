package br.com.leomanzini.dollar.price.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.leomanzini.dollar.price.dto.DollarResponse;

@Repository
public interface DollarPriceRepository extends JpaRepository<DollarResponse, Long> {

}
