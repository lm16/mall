package com.store.model.viewModel;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartVM {

    private Integer id;

    private Short count;

    // inner join
    private String name;
    private BigDecimal price;

}
