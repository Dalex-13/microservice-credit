package com.nttdata.microservicecredit.infraestructure.rest;

import com.nttdata.microservicecredit.application.TCreditOperations;
import com.nttdata.microservicecredit.domain.TCredit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/Typecredits")
@RequiredArgsConstructor
public class TCreditController {

    private final TCreditOperations tCreditOperations;

    @GetMapping
    public Flux<TCredit> get() {
        log.info("Listado de Usuarios");
        return tCreditOperations.queryAll();
    }

    @GetMapping("/{id}")
    public Mono<TCredit> getId(@PathVariable String id) {
        return tCreditOperations.findId(id);
    }

    @PostMapping("/add")
    public Mono<TCredit> post(@RequestBody TCredit tCredit) {
        return tCreditOperations.create(tCredit);
    }

    @PutMapping("/{id}")
    public Mono<TCredit> put(@PathVariable String id, @RequestBody TCredit tCredit) {
        return tCreditOperations.update(id, tCredit);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){

        return tCreditOperations.delete(id);
    }
}
