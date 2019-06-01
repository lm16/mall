package com.store.model.basic;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Goods {

    @TableId
    private Integer id;
    private String name;
    private BigDecimal price;

    private Short stock;
    private Short sold;
    private Integer cid;

}
