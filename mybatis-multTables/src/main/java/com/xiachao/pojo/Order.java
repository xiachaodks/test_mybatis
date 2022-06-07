package com.xiachao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    private Integer orderId;
    private Date orderTime;
    private Double total;

    private Person person;

}
