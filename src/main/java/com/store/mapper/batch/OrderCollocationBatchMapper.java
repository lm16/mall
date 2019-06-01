package com.store.mapper.batch;

import com.store.model.batch.OrderCollocationBatch;
import com.store.model.part.OrderCollocationPart;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;

@Mapper
public interface OrderCollocationBatchMapper {

    @Insert("insert into `order`(aid) values(#{aid})")
    @Options(keyColumn = "id", useGeneratedKeys = true, keyProperty = "id" )
    void add(OrderCollocationBatch orderCollocationBatch);


    @Insert("insert into `order`(aid) values(#{aid})")
    @Options(keyColumn = "id", useGeneratedKeys = true, keyProperty = "id" )
    void add2(OrderCollocationPart collocationPart);

    @Update("update order set total=#{b} where id=#{a};")
    void update(@Param("a") Integer oid, @Param("b") BigDecimal total);

    /*

     */



}
