package com.xiachao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private Integer personId;
    private String personName;
    private Date birthday;

    //描述该用户用那些订单
    private List<Order> orderList;

}
