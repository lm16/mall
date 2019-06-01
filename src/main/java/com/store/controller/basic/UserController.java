package com.store.controller.basic;

import com.store.mapper.basic.UserMapper;
import com.store.model.basic.User;
import com.store.model.result.Result;
import com.store.model.result.ResultType;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping()
    @ApiOperation("做注册")
    public Result user(@RequestBody User user){

        userMapper.add(user);

        return Result.build(ResultType.Success);
    }

}
