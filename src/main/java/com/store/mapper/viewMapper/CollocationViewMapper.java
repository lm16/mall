package com.store.mapper.viewMapper;

import com.store.model.viewModel.CollocationVM;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollocationViewMapper {


    @Select("select b.name 'goods', b.price, a.`count`, a.subTotal\n" +
            "from collocation a\n" +
            "inner join goods b on a.gid=b.id\n" +
            "where a.oid=#{a};")
    List<CollocationVM> getByOid(@Param("a") Integer id);


}
