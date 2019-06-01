package com.store.mapper.basic;


import com.store.model.basic.Cart;
import com.store.model.basic.Collocation;
import org.apache.ibatis.annotations.*;


@Mapper
public interface CartMapper {

    @Insert("insert into cart(gid, count, uid) values( #{a.gid}, #{a.count}, #{b} )")
    void add(@Param("a") Cart cart, @Param("b") Integer uid);


    @Update("update cart set count=#{a.count} where id=#{a.id} and uid=#{b};")
    void update(@Param("a") Cart cart, @Param("b") Integer uid);


    @Delete("delete from cart\n" +
            "where id=#{a} and uid=#{b};")
    void delete(@Param("a") Integer id, @Param("b") Integer uid);

    /*

     */

    @Select("select a.gid, a.`count`,  b.price*a.`count` 'subTotal'\n" +
            "from cart a\n" +
            "inner join goods b on a.gid=b.id\n" +
            "where a.id=#{id};")
    Collocation toCollocation(Integer id);

}
