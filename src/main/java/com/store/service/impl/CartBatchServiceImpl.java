package com.store.service.impl;

import com.store.mapper.basic.CartMapper;
import com.store.service.basic.CartBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartBatchServiceImpl implements CartBatchService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public void delete(Integer[] array, Integer uid) {

        for(Integer id: array){
            cartMapper.delete(id, uid);
        }

    }
}
