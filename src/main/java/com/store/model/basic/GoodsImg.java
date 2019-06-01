package com.store.model.basic;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsImg {

    private Integer id;

    private String name;
    private BigDecimal price;
    private Short sold;

    // one
    private String img;

    private Integer cid;

}
