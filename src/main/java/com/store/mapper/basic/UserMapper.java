package com.store.mapper.basic;

import com.store.model.basic.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {


    @Insert("insert into `user`(email, name, nick, passwd) values (#{email}, #{name}, #{nick}, #{passwd});")
    void add(User user);

}
