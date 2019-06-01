package com.store.service.impl;


import com.store.mapper.basic.GoodsDetailMapper;
import com.store.mapper.basic.ImgMapper;
import com.store.model.basic.GoodsDetail;
import com.store.model.basic.Img;
import com.store.service.basic.GoodsDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsDetailServiceImpl implements GoodsDetailService {


    @Autowired
    private GoodsDetailMapper goodsDetailMapper;
    @Autowired
    private ImgMapper imgMapper;

    public GoodsDetail one(int id){
        GoodsDetail goodsDetail = goodsDetailMapper.one(id);

        Img img = imgMapper.one(id);
        String[] array = new String[]{img.getMain(), img.getImg1(), img.getImg2(), img.getImg3()};
        goodsDetail.setImg(array);

        return goodsDetail;
    }

}
