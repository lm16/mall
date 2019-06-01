package com.store.service.basic;

import com.store.model.batch.OrderCollocationBatch;
import com.store.model.part.OrderCollocationPart;

public interface OrderCollocationBatchService {

    void fromCart(OrderCollocationBatch orderCollocationBatch, Integer uid);

    void add(OrderCollocationPart orderCollocationPart);
}
