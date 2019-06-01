package com.store;

import com.store.mapper.basic.*;
import com.store.mapper.basic.AddressMapper;
import com.store.mapper.basic.AuthMapper;
import com.store.mapper.batch.OrderCollocationBatchMapper;
import com.store.service.basic.OrderCollocationBatchService;
import com.store.service.impl.GoodsDetailServiceImpl;
import com.store.service.impl.AuthIdServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreApplicationTests {

    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private ImgMapper imgMapper;
    @Autowired
    private OrderCollocationBatchMapper orderMapper;
    @Autowired
    private GoodsImgMapper goodsImgMapper;
    @Autowired
    private GoodsDetailMapper goodsDetailMapper;
    @Autowired
    private AuthMapper authMapper;

    /*
    Service
     */

    @Autowired
    private GoodsDetailServiceImpl arrayService;
    @Autowired
    private AuthIdServiceImpl authService;
    @Autowired
    private OrderCollocationBatchService orderCartVMService;




}


