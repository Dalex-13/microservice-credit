package com.nttdata.microservicecredit.infraestructure.repository;


import com.nttdata.microservicecredit.infraestructure.dao.CurrencyDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ICurrencyCrudRepository extends ReactiveCrudRepository<CurrencyDao, String> {
}
