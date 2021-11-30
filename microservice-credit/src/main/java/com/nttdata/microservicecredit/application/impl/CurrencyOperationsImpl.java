package com.nttdata.microservicecredit.application.impl;

import com.nttdata.microservicecredit.application.CurrencyOperations;
import com.nttdata.microservicecredit.application.model.CurrencyRepository;
import com.nttdata.microservicecredit.domain.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CurrencyOperationsImpl implements CurrencyOperations {

    private final CurrencyRepository repository;

    @Override
    public Flux<Currency> queryAll() {
        return repository.getAll();
    }

    @Override
    public Mono<Currency> findId(String id) {
        return repository.getId(id);
    }

    @Override
    public Mono<Currency> create(Currency currency) {
        return repository.save(currency);
    }

    @Override
    public Mono<Currency> update(String id, Currency currency) {
        return repository.update(id, currency);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.delete(id);
    }
}
