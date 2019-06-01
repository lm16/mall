package com.store.controller.authController;

import com.store.mapper.basic.CartMapper;
import com.store.mapper.viewMapper.CartViewMapper;
import com.store.model.basic.Cart;
import com.store.model.batch.CartBatch;
import com.store.model.result.Result;
import com.store.model.result.ResultType;
import com.store.service.basic.CartBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("authCart")
public class AuthCartController {

    @Autowired
    private CartViewMapper cartViewMapper;
    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private CartBatchService cartBatchService;



    @GetMapping
    public Result authCart(HttpSession session){
        String auth = session.getAttribute("auth").toString();

        return Result.build(ResultType.Success).appendData("list", cartViewMapper.getByUid(Integer.valueOf(auth)));
    }


    @PostMapping
    public Result authCartPost(@RequestBody Cart cart, HttpSession session){
        String auth = session.getAttribute("auth").toString();

        cartMapper.add(cart, Integer.valueOf(auth));

        return Result.build(ResultType.Success);
    }


    @PutMapping()
    public Result authCartPut(@RequestBody Cart cart, HttpSession session){
        String auth = session.getAttribute("auth").toString();

        cartMapper.update(cart, Integer.valueOf(auth));

        return Result.build(ResultType.Success);
    }

    @DeleteMapping("{id}")
    public Result authCartIdDelete(@PathVariable("id") Integer id, HttpSession session){
        String auth = session.getAttribute("auth").toString();

        cartMapper.delete(id, Integer.valueOf(auth));

        return Result.build(ResultType.Success);
    }

    @DeleteMapping()
    public Result authCartDelete(@RequestBody CartBatch cartBatch, HttpSession session){
        String auth = session.getAttribute("auth").toString();

        cartBatchService.delete(cartBatch.getId(), Integer.valueOf(auth));

        return Result.build(ResultType.Success);
    }

}
