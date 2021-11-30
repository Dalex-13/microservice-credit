package com.nttdata.microservicecredit.infraestructure.repository;


import com.nttdata.microservicecredit.infraestructure.dao.TCreditDao;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ITCreditCrudRepository extends ReactiveCrudRepository<TCreditDao, String> {
}
