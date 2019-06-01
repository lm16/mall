package com.store.mapper.basic;

import com.store.model.basic.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AddressMapper {

    @Insert("insert into address (name, receive_phone, receive_name, uid) \n" +
            "values(#{a.name}, #{a.receivePhone}, #{a.receiveName}, #{b});")
    void add(@Param("a") Address address, @Param("b") Integer uid);

    /*

     */

    @Select("select a.id, a.name, a.receive_name, a.receive_phone \n" +
            "from address a\n" +
            "where a.uid=#{uid};")
    List<Address> getByUid(Integer uid);


    @Select("select a.name, a.receive_name, a.receive_phone \n" +
            "from address a\n" +
            "where a.id=#{id};")
    Address one(Integer id);

}
