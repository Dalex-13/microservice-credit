package com.nttdata.microservicecredit.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Currency {

    @Id
    private String id;
    private String name;
    private String symbol;
}
