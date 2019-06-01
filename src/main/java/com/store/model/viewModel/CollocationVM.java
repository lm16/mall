package com.store.model.viewModel;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CollocationVM {

    // inner join
    private String goods;
    private BigDecimal price;

    private Short count;

    // *
    private BigDecimal subTotal;

}
