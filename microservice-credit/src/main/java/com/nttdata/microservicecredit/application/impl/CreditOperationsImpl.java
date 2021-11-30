package com.nttdata.microservicecredit.application.impl;

import com.nttdata.microservicecredit.application.CreditOperations;
import com.nttdata.microservicecredit.application.model.CreditRepository;
import com.nttdata.microservicecredit.domain.Credit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreditOperationsImpl implements CreditOperations {

    private final CreditRepository repository;

    @Override
    public Flux<Credit> queryAll() {
        return repository.getAll();
    }

    @Override
    public Mono<Credit> findId(String id) {
        return repository.getId(id);
    }

    @Override
    public Mono<Credit> create(Credit credit) {
        return repository.save(credit);
    }

    @Override
    public Mono<Credit> update(String id, Credit credit) {
        return repository.update(id, credit);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.delete(id);
    }
}
