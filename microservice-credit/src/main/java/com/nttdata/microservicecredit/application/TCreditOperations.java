package com.nttdata.microservicecredit.application;

import com.nttdata.microservicecredit.domain.TCredit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TCreditOperations {

    public Flux<TCredit> queryAll();
    public Mono<TCredit> findId(String id);
    public Mono<TCredit> create(TCredit tCredit);
    public Mono<TCredit> update(String id, TCredit tCredit);
    public Mono<Void> delete(String id);
}
