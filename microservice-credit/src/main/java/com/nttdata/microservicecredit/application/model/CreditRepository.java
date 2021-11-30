package com.nttdata.microservicecredit.application.model;

import com.nttdata.microservicecredit.domain.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditRepository {

    Mono<Credit> getId(String id);
    Flux<Credit> getAll();
    Mono<Credit> save(Credit credit);
    Mono<Credit> update(String id, Credit credit);
    Mono<Void> delete(String id);
}
