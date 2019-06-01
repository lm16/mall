package com.store.service.impl;

import com.store.mapper.basic.CartMapper;
import com.store.mapper.basic.CollocationMapper;
import com.store.mapper.batch.OrderCollocationBatchMapper;
import com.store.model.basic.Collocation;
import com.store.model.batch.OrderCollocationBatch;
import com.store.model.part.OrderCollocationPart;
import com.store.service.basic.OrderCollocationBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderCollocationBatchServiceImpl implements OrderCollocationBatchService {

    @Autowired
    private OrderCollocationBatchMapper orderMapper;
    @Autowired
    private CollocationMapper collocationMapper;
    @Autowired
    private CartMapper cartMapper;

    @Override
    public void fromCart(OrderCollocationBatch orderCartBatch, Integer uid) {

        orderMapper.add(orderCartBatch);

        Integer oid = orderCartBatch.getId();
        BigDecimal total = new BigDecimal(0);

        for(Integer cartId: orderCartBatch.getCartId()){

            Collocation collocation = cartMapper.toCollocation(cartId);

            collocationMapper.add(collocation, oid);
            total = total.add(collocation.getSubTotal());

            cartMapper.delete(cartId, uid);
        }

        orderMapper.update(oid, total);
    }

    @Override
    public void add(OrderCollocationPart orderCollocationPart) {

        orderMapper.add2(orderCollocationPart);

        Integer oid = orderCollocationPart.getId();

        BigDecimal subTotal = collocationMapper.fromGoods(orderCollocationPart.getGid(), orderCollocationPart.getCount());
        collocationMapper.add2(orderCollocationPart.getGid(), orderCollocationPart.getCount(), subTotal, oid);

        orderMapper.update(oid, subTotal);
    }
}
