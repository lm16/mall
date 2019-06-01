package com.store.controller.basic;

import com.store.mapper.basic.GoodsImgMapper;
import com.store.model.result.Result;
import com.store.model.result.ResultType;
import com.store.service.basic.GoodsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsImgMapper goodsImgMapper;
    @Autowired
    private GoodsDetailService goodsDetailService;

    @GetMapping()
    public Result getGoods(@RequestParam(value = "like", required = false) String like,
                           @RequestParam(value="type", required = false) Integer type) {
        if (like==null && type==null) {
            return Result.build(ResultType.Success).appendData("list", goodsImgMapper.all());
        }else if(like==null) {
            return Result.build(ResultType.Success).appendData("list", goodsImgMapper.like1(type));
        }else if(type==null) {
            return Result.build(ResultType.Success).appendData("list", goodsImgMapper.like2('%'+like+'%'));
        }else{
            return Result.build(ResultType.Success).appendData("list", goodsImgMapper.like3("%"+like+"%", type));
        }
    }

    @GetMapping("/{id}")
    public Result goodsId(@PathVariable int id){
        return Result.build(ResultType.Success).appendData("list", goodsDetailService.one(id));
    }

}
