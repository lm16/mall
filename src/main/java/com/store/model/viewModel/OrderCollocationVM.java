package com.store.model.viewModel;

import com.store.model.basic.Address;
import lombok.Data;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
public class OrderCollocationVM {

    private Date time;
    private String state;

    // total = total.add(collocation.getSubTotal())
    private BigDecimal total;

    // one
    private Address address;

    // many
    private List<CollocationVM> cart;



    // format
    public String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(time);
    }
}
