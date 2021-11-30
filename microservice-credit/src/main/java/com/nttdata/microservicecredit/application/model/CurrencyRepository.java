package com.nttdata.microservicecredit.application.model;

import com.nttdata.microservicecredit.domain.Currency;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CurrencyRepository {

    Mono<Currency> getId(String id);
    Flux<Currency> getAll();
    Mono<Currency> save(Currency currency);
    Mono<Currency> update(String id, Currency currency);
    Mono<Void> delete(String id);
}
