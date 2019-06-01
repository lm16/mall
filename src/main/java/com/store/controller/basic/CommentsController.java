package com.store.controller.basic;

import com.store.model.result.Result;
import com.store.model.result.ResultType;
import com.store.mapper.viewMapper.CommentsViewMapper;
import com.store.mapper.basic.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentsController {


    @Autowired
    private CommentsViewMapper commentsViewMapper;


    @GetMapping()
    public Result commentsGid(@RequestParam(value = "gid") int gid){

        return Result.build(ResultType.Success).appendData("list", commentsViewMapper.getByGid(gid));
    }

}
