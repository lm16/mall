package com.store.model.batch;

import lombok.Data;


@Data
public class OrderCollocationBatch {

    private Integer id;
    private Integer aid;

    private Integer[] cartId;

}
