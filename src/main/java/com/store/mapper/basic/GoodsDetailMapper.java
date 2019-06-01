package com.store.mapper.basic;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.store.model.basic.GoodsDetail;
import org.apache.ibatis.annotations.*;

@Mapper
public interface GoodsDetailMapper extends BaseMapper{


    @Select("select a.name, a.price, a.stock, a.sold, b.name 'type'\n" +
            "from goods a\n" +
            "inner join category b on a.cid=b.id\n" +
            "where a.id=#{id};;")
    GoodsDetail one(int id);

}
