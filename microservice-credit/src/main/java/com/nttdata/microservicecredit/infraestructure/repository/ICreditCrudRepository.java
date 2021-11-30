package com.nttdata.microservicecredit.infraestructure.repository;


import com.nttdata.microservicecredit.infraestructure.dao.CreditDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ICreditCrudRepository extends ReactiveCrudRepository<CreditDao, String> {
}
