package com.store.mapper.viewMapper;

import com.store.model.viewModel.CommentsVM;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentsViewMapper {

    @Select("select a.id, a.`time`, b.nick, a.content, a.star  " +
            "from comments a " +
            "inner join user b on a.uid=b.id " +
            "where gid=#{gid};")
    List<CommentsVM> getByGid(int gid);

}
