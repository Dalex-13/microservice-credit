package com.nttdata.microservicecredit.infraestructure.rest;

import com.nttdata.microservicecredit.application.CurrencyOperations;
import com.nttdata.microservicecredit.domain.Currency;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyOperations currencyOperations;

    @GetMapping
    public Flux<Currency> get() {
        log.info("Listado de Usuarios");
        return currencyOperations.queryAll();
    }

    @GetMapping("/{id}")
    public Mono<Currency> getId(@PathVariable String id) {
        return currencyOperations.findId(id);
    }

    @PostMapping("/add")
    public Mono<Currency> post(@RequestBody Currency currency) {
        return currencyOperations.create(currency);
    }

    @PutMapping("/{id}")
    public Mono<Currency> put(@PathVariable String id, @RequestBody Currency currency) {
        return currencyOperations.update(id, currency);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id){

        return currencyOperations.delete(id);
    }




}
