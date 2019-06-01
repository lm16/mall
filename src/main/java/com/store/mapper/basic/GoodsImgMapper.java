package com.store.mapper.basic;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.store.model.basic.GoodsImg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsImgMapper extends BaseMapper<GoodsImg> {

    @Select("select a.id, a.name, a.cid, a.price, a.sold, b.main 'img' " +
            "from mall_v2.goods a " +
            "left join mall_v2.img b on b.gid=a.id;")
    List<GoodsImg> all();


    @Select("select a.id, a.name, a.price, a.sold, b.main 'img' " +
            "from mall_v2.goods a " +
            "left join mall_v2.img b on b.gid=a.id " +
            "where a.cid=#{type};")
    List<GoodsImg> like1(int type);


    @Select("select a.id, a.name, a.price, a.sold, b.main 'img' " +
            "from mall_v2.goods a " +
            "left join mall_v2.img b on b.gid=a.id " +
            "where a.name like #{like};")
    List<GoodsImg> like2(String like);


    @Select("select a.id, a.name, a.price, a.sold, b.main 'img' " +
            "from mall_v2.goods a " +
            "left join mall_v2.img b on b.gid=a.id " +
            "where a.name like #{like} and a.cid=#{type};")
    List<GoodsImg> like3(@Param("like") String like, @Param("type") int type);

}
