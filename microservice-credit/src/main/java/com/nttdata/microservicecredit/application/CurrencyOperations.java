package com.nttdata.microservicecredit.application;

import com.nttdata.microservicecredit.domain.Currency;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CurrencyOperations {

    public Flux<Currency> queryAll();
    public Mono<Currency> findId(String id);
    public Mono<Currency> create(Currency currency);
    public Mono<Currency> update(String id, Currency currency);
    public Mono<Void> delete(String id);
}
