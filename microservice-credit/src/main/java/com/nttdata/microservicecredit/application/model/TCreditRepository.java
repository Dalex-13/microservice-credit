package com.nttdata.microservicecredit.application.model;

import com.nttdata.microservicecredit.domain.TCredit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TCreditRepository {

    Mono<TCredit> getId(String id);
    Flux<TCredit> getAll();
    Mono<TCredit> save(TCredit tCredit);
    Mono<TCredit> update(String id, TCredit tCredit);
    Mono<Void> delete(String id);
}
