package com.store.mapper.basic;

import com.store.model.position.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PositionMapper {

    @Select("select a.provice_id, provice_name \n" +
            "from j_position_provice a;")
    List<Province> province();

    @Select("select a.city_id, a.city_name\n" +
            "from j_position_city a\n" +
            "where a.province_id = #{a};")
    List<City> city(Integer a);

    @Select("select a.county_id, a.county_name\n" +
            "from j_position_county a\n" +
            "where a.city_id=#{a};")
    List<County> county(Long a);

    @Select("select a.town_id, a.town_name\n" +
            "from j_position_town a\n" +
            "where a.county_id=#{a};")
    List<Town> town(Long a);

    @Select("select a.village_id, a.village_name\n" +
            "from j_position_village a\n" +
            "where a.town_id=#{a};")
    List<Village> village(Long a);

}
