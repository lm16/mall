package com.store.controller.authController;

import com.store.model.basic.Address;
import com.store.model.result.Result;
import com.store.model.result.ResultType;
import com.store.mapper.basic.AddressMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("authAddress")
public class AuthAddressController {

    @Autowired
    private AddressMapper addressMapper;

    @GetMapping()
    @ApiOperation("显示所持有的地址")
    public Result getAddress(HttpSession session){

        String auth = session.getAttribute("auth").toString();

        return Result.build(ResultType.Success).appendData("list", addressMapper.getByUid(Integer.valueOf(auth)));

    }

    @PostMapping()
    @ApiOperation("地址提交")
    public Result postAddress(@RequestBody Address address, HttpSession session){

        String auth = session.getAttribute("auth").toString();

        addressMapper.add(address, Integer.valueOf(auth));

        return Result.build(ResultType.Success);
    }

    @PutMapping()
    @ApiOperation("修改地址")
    public Result addressPut(@RequestBody Address address){


        return Result.build(ResultType.Success);
    }

}