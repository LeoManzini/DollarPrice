package br.com.leomanzini.dollar.price.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.leomanzini.dollar.price.entity.RealTimeDollarEntity;

public interface RealTimeDollarRepository extends JpaRepository<RealTimeDollarEntity, Long> {

}
