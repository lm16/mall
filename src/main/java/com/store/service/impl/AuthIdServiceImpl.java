package com.store.service.impl;

import com.store.mapper.basic.AuthMapper;
import com.store.model.basic.Auth;
import com.store.service.basic.AuthIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthIdServiceImpl implements AuthIdService {


    @Autowired
    private AuthMapper authMapper;

    @Override
    public int login(Auth auth) {

        Auth one = authMapper.getByName(auth.getName());


        if(one == null){
            return -1;
        }else{
            if(auth.getPasswd().equals(one.getPasswd())){
                return one.getId();
            }else{
                return -1;
            }
        }
    }

}
