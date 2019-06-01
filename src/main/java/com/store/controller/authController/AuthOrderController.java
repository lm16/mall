package com.store.controller.authController;

import com.store.mapper.viewMapper.OrderCollocationViewMapper;
import com.store.model.part.OrderCollocationPart;
import com.store.model.result.Result;
import com.store.model.result.ResultType;
import com.store.model.batch.OrderCollocationBatch;
import com.store.service.basic.OrderCollocationBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("authOrder")
public class AuthOrderController {

    @Autowired
    private OrderCollocationBatchService orderCartVMService;
    @Autowired
    private OrderCollocationViewMapper orderCartViewMapper;

    @GetMapping()
    public Result authOrderGet(HttpSession session){
        String auth = session.getAttribute("auth").toString();

        return Result.build(ResultType.Success).appendData("list", orderCartViewMapper.getByUid(Integer.valueOf(auth)));
    }

    @PostMapping()
    public Result authOrderPost(@RequestBody OrderCollocationPart orderCollacationPart){

        orderCartVMService.add(orderCollacationPart);

        return Result.build(ResultType.Success);
    }

    @PostMapping("fromCart")
    public Result fromCart(@RequestBody OrderCollocationBatch orderCartVM, HttpSession session){

        String auth = session.getAttribute("auth").toString();

        orderCartVMService.fromCart(orderCartVM, Integer.valueOf(auth));

        return Result.build(ResultType.Success);
    }

}
