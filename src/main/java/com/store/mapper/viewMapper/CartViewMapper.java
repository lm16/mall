package com.store.mapper.viewMapper;

import com.store.model.viewModel.CartVM;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CartViewMapper {


    @Select("select a.id, b.name, b.price, a.`count` \n" +
            "from cart a\n" +
            "inner join goods b on a.gid=b.id\n" +
            "where a.uid=#{id};")
    List<CartVM> getByUid(int id);

}
