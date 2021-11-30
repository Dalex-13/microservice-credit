package com.nttdata.microservicecredit.infraestructure.repository.impl;

import com.nttdata.microservicecredit.application.model.TCreditRepository;
import com.nttdata.microservicecredit.domain.TCredit;
import com.nttdata.microservicecredit.infraestructure.dao.TCreditDao;
import com.nttdata.microservicecredit.infraestructure.repository.ITCreditCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TCreditCrudRepositoryImpl implements TCreditRepository {

    @Autowired
    private ITCreditCrudRepository repository;

    @Override
    public Mono<TCredit> getId(String id) {
        return repository.findById(id)
                .map(this::mapTCreditDaoToUser);
    }

    @Override
    public Flux<TCredit> getAll() {
        return repository.findAll()
                .map(this::mapTCreditDaoToUser);
    }

    @Override
    public Mono<TCredit> save(TCredit tCredit) {
        return repository.save(mapTCreditToUserDao(tCredit))
                .map(this::mapTCreditDaoToUser);
    }

    @Override
    public Mono<TCredit> update(String id, TCredit tCredit) {
        return repository.save(mapTCreditToUserDao(tCredit))
                .map(this::mapTCreditDaoToUser);
    }



    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }




    //metodos

    private TCredit mapTCreditDaoToUser(TCreditDao tCreditDao){
        TCredit tCredit = new TCredit();
        tCredit.setId(tCreditDao.getId());
        tCredit.setName(tCreditDao.getName());
        tCredit.setCurrentbalance(tCreditDao.getCurrentbalance());
        tCredit.setCreditgranted(tCreditDao.getCreditgranted());
        return tCredit;
    }

    private TCreditDao mapTCreditToUserDao(TCredit tCredit){
        TCreditDao tCreditDao = new TCreditDao();
        tCreditDao.setId(tCredit.getId());
        tCreditDao.setName(tCredit.getName());
        tCreditDao.setCurrentbalance(tCredit.getCurrentbalance());
        tCreditDao.setCreditgranted(tCredit.getCreditgranted());
        return tCreditDao;
    }
}
