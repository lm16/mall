package com.store.controller.authController;

import com.store.model.result.Result;
import com.store.model.result.ResultType;
import com.store.mapper.basic.PositionMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authPosition")
public class AuthPositionController {

    @Autowired
    private PositionMapper positionMapper;

    @GetMapping()
    @ApiOperation("地址有效信息")
    public Result getAddress(@RequestParam(value = "provice", required = false)Integer provice,
                            @RequestParam(value = "city", required = false) Long city,
                            @RequestParam(value = "county", required = false) Long county,
                            @RequestParam(value = "town", required = false) Long town,
                            @RequestParam(value = "village", required = false) Long village){

        if(provice==null && city==null && county==null && town==null && village==null){
            return Result.build(ResultType.Success).appendData("list", positionMapper.province());

        }else if(provice!=null && city==null && county==null && town==null && village==null){
            return Result.build(ResultType.Success).appendData("list", positionMapper.city(provice));

        }else if(provice==null && city!=null && county==null && town==null && village==null){
            return Result.build(ResultType.Success).appendData("list", positionMapper.county(city));

        }else if(provice==null && city==null && county!=null && town==null && village==null){
            return Result.build(ResultType.Success).appendData("list", positionMapper.town(county));
        }else if(provice==null && city==null && county==null && town!=null && village==null){
            return Result.build(ResultType.Success).appendData("list", positionMapper.village(town));
        }else{
            return Result.build(ResultType.Failed);
        }

    }

}
