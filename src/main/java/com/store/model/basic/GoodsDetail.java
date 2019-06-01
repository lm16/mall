package com.store.model.basic;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsDetail {

    private String name;
    private BigDecimal price;

    private Short stock;
    private Short sold;

    private String type;

    private String[] img;

}
