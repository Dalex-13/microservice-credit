package com.nttdata.microservicecredit.infraestructure.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("typeCredit")
public class TCreditDao {

    @Id
    private String id;
    private String name;
    private String currentbalance;
    private String creditgranted;
}
