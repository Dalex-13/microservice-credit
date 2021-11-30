package com.nttdata.microservicecredit.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Credit {

    @Id
    private String id;
    private String idcustomer;
    private String idtypecredit;
    private String idmoney;
    private String amount;
    private String amountavailable;
}
