package com.store.model.basic;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Comments {

    @TableId
    private Integer cid;
    private Date time;
    private String content;

    private Byte star;
    private Integer gid;
    private Integer uid;

}
