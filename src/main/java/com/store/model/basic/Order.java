package com.store.model.basic;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order {

    @TableId
    private Integer id;

    private Date time;

    private Integer aid;

    private BigDecimal pay;

    private String state;

}
