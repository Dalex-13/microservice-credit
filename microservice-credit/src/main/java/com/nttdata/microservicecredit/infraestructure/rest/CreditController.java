package com.nttdata.microservicecredit.infraestructure.rest;

import com.nttdata.microservicecredit.application.CreditOperations;
import com.nttdata.microservicecredit.domain.Credit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/credits")
@RequiredArgsConstructor
public class CreditController {

    private final CreditOperations creditOperations;

    @GetMapping
    public Flux<Credit> get() {
        log.info("Listado de Usuarios");
        return creditOperations.queryAll();
    }

    @GetMapping("/{id}")
    public Mono<Credit> getId(@PathVariable String id) {
        return creditOperations.findId(id);
    }

    @PostMapping("/add")
    public Mono<Credit> post(@RequestBody Credit credit) {
        log.info("creacion de creditos");
        return creditOperations.create(credit);
    }

    @PutMapping("/{id}")
    public Mono<Credit> put(@PathVariable String id, @RequestBody Credit credit) {
        return creditOperations.update(id, credit);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){

        return creditOperations.delete(id);
    }
}
