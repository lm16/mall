package com.store.mapper.basic;

import com.store.model.basic.Img;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ImgMapper{

    @Select("select a.main, a.img1, a.img2, a.img3 " +
            "from img a where a.gid = #{id};")
    Img one(int id);
}
