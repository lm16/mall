package com.store.model.basic;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Collocation {

    private Integer gid;
    private Short count;
    private BigDecimal subTotal;

}
