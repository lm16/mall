package com.store.mapper.viewMapper;

import com.store.model.viewModel.OrderCollocationVM;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderCollocationViewMapper {

    @Select("select a.*\n" +
            "from `order` a\n" +
            "inner join address b on a.aid=b.id\n" +
            "inner join `user` c on b.uid=c.id\n" +
            "where c.id=#{a}\n" +
            "order by a.`time` desc;")
    @Results({
            @Result(column="aid", property = "address", one=@One(select = "com.store.mapper.mapper.AddressMapper.one")),
            @Result(column="id", property="cart", many = @Many(select = "com.store.mapper.viewMapper.CollocationViewMapper.getByOid"))
    })
    List<OrderCollocationVM> getByUid(@Param("a") Integer id);




}
