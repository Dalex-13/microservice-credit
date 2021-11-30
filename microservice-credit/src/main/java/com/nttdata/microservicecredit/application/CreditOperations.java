package com.nttdata.microservicecredit.application;

import com.nttdata.microservicecredit.domain.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditOperations {

    public Flux<Credit> queryAll();
    public Mono<Credit> findId(String id);
    public Mono<Credit> create(Credit credit);
    public Mono<Credit> update(String id, Credit credit);
    public Mono<Void> delete(String id);
}
