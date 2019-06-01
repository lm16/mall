package com.store.model.basic;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
public class Address {

    private Integer id;
    private String name;

    @Size(min=2, max=3, message = "姓名格式有误")
    private String receiveName;

    @Min(value = 10000000000L, message="手机号码格式有误")
    @Max(value = 19999999999L, message="手机号码格式有误")
    private Long receivePhone;

}
