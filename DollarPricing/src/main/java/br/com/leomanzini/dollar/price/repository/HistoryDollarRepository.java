package br.com.leomanzini.dollar.price.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leomanzini.dollar.price.entity.HistoryDollarEntity;

public interface HistoryDollarRepository extends JpaRepository<HistoryDollarEntity, Long> {

}
