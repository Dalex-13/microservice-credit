package com.nttdata.microservicecredit.infraestructure.repository.impl;

import com.nttdata.microservicecredit.application.model.CurrencyRepository;
import com.nttdata.microservicecredit.domain.Currency;
import com.nttdata.microservicecredit.infraestructure.dao.CurrencyDao;
import com.nttdata.microservicecredit.infraestructure.repository.ICurrencyCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component//revizar
public class CurrencyCrudRepositoryImpl implements CurrencyRepository {

    @Autowired
    private ICurrencyCrudRepository repository;

    @Override
    public Mono<Currency> getId(String id) {
        return repository.findById(id)
                .map(this::mapCurrencyDaoToUser);
    }

    @Override
    public Flux<Currency> getAll() {
        return repository.findAll()
                .map(this::mapCurrencyDaoToUser);
    }

    @Override
    public Mono<Currency> save(Currency currency) {
        return repository.save(mapCurrencyToUserDao(currency))
                .map(this::mapCurrencyDaoToUser);
    }

    @Override
    public Mono<Currency> update(String id, Currency currency) {
        return repository.save(mapCurrencyToUserDao(currency))
                .map(this::mapCurrencyDaoToUser);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }



    //metodos

    private Currency mapCurrencyDaoToUser(CurrencyDao currencyDao){
        Currency currency = new Currency();
        currency.setId(currencyDao.getId());
        currency.setName(currencyDao.getName());
        currency.setSymbol(currencyDao.getSymbol());
        return currency;
    }

    private CurrencyDao mapCurrencyToUserDao(Currency currency){
        CurrencyDao currencyDao = new CurrencyDao();
        currencyDao.setId(currency.getId());
        currencyDao.setName(currency.getName());
        currencyDao.setSymbol(currency.getSymbol());
        return currencyDao;
    }
}
