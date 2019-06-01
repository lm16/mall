package com.store.mapper.basic;

import com.store.model.basic.Auth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AuthMapper {

    @Select("select a.id, a.name, a.passwd " +
            "from `user` a " +
            "where name=#{name};")
    Auth getByName(String name);

}
