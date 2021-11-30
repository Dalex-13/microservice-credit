package com.nttdata.microservicecredit.application.impl;

import com.nttdata.microservicecredit.application.TCreditOperations;
import com.nttdata.microservicecredit.application.model.TCreditRepository;
import com.nttdata.microservicecredit.domain.TCredit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TCreditOperationsImpl implements TCreditOperations {

    private final TCreditRepository repository;

    @Override
    public Flux<TCredit> queryAll() {
        return repository.getAll();
    }

    @Override
    public Mono<TCredit> findId(String id) {
        return repository.getId(id);
    }

    @Override
    public Mono<TCredit> create(TCredit tCredit) {return repository.save(tCredit);}

    @Override
    public Mono<TCredit> update(String id, TCredit tCredit) {
        return repository.update(id, tCredit);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.delete(id);
    }
}


