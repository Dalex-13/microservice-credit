package com.nttdata.microservicecredit.infraestructure.dao;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("currency")
public class CurrencyDao {

    @Id
    private String id;
    private String name;
    private String symbol;
}
