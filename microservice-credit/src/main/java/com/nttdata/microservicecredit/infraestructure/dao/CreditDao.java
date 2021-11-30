package com.nttdata.microservicecredit.infraestructure.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("credit")
public class CreditDao {

    @Id
    private String id;
    private String idcustomer;
    private String idtypecredit;
    private String idmoney;
    private String amount;
    private String amountavailable;
}
