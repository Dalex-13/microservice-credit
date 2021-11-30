package com.nttdata.microservicecredit.infraestructure.repository.impl;

import com.nttdata.microservicecredit.application.model.CreditRepository;
import com.nttdata.microservicecredit.domain.Credit;
import com.nttdata.microservicecredit.infraestructure.dao.CreditDao;
import com.nttdata.microservicecredit.infraestructure.repository.ICreditCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CreditCrudRepositoryImpl implements CreditRepository {

    @Autowired
    private ICreditCrudRepository repository;

    @Override
    public Mono<Credit> getId(String id) {
        return repository.findById(id)
                .map(this::mapCreditDaoToUser);
    }

    @Override
    public Flux<Credit> getAll() {
        return repository.findAll()
                .map(this::mapCreditDaoToUser);
    }

    @Override
    public Mono<Credit> save(Credit credit) {
        return repository.save(mapCreditToUserDao(credit))
                .map(this::mapCreditDaoToUser);
    }

    @Override
    public Mono<Credit> update(String id, Credit credit) {
        return repository.save(mapCreditToUserDao(credit))
                .map(this::mapCreditDaoToUser);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }




    //metodos

    private Credit mapCreditDaoToUser(CreditDao creditDao){
        Credit credit = new Credit();
        credit.setId(creditDao.getId());
        credit.setIdcustomer(creditDao.getIdcustomer());
        credit.setIdtypecredit(creditDao.getIdtypecredit());
        credit.setIdmoney(creditDao.getIdmoney());
        credit.setAmount(creditDao.getAmount());
        credit.setAmountavailable(creditDao.getAmountavailable());
        return credit;
    }

    private CreditDao mapCreditToUserDao(Credit credit){
        CreditDao creditDao = new CreditDao();
        creditDao.setId(credit.getId());
        creditDao.setIdcustomer(credit.getIdcustomer());
        creditDao.setIdtypecredit(credit.getIdtypecredit());
        creditDao.setIdmoney(credit.getIdmoney());
        creditDao.setAmount(credit.getAmount());
        creditDao.setAmountavailable(credit.getAmountavailable());
        return creditDao;
    }
}

