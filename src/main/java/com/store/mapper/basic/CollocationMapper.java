package com.store.mapper.basic;

import com.store.model.basic.Collocation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;

@Mapper
public interface CollocationMapper {


    @Insert("insert into collocation(gid, `count`, subTotal,  oid)\n" +
            "values (#{a.gid}, #{a.count}, #{a.subTotal}, #{oid};")
    void add(@Param("a")Collocation collocation, @Param("oid") Integer oid);

    @Insert("insert into collocation(gid, `count`, subTotal,  oid)\n" +
            "values (#{a}, #{b}, #{c}, #{d};")
    void add2(@Param("a") Integer gid, @Param("b") Short count, @Param("c") BigDecimal subTotal, @Param("d") Integer oid);

    /*

     */

    @Select("select price*#{b}\n" +
            "from goods\n" +
            "where id=#{a};")
    BigDecimal fromGoods(@Param("a") Integer gid, @Param("b") Short count);

}
