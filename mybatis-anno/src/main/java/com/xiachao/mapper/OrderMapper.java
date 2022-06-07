package com.xiachao.mapper;

import com.xiachao.pojo.Order;
import com.xiachao.pojo.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

    @Select("select * from orders")
    @Results({
            @Result(id = true,column = "orderId",property = "orderId"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "total",property = "total"),
            @Result(
                    column = "personId",
                    property = "person",
                    javaType = Person.class,
                    one = @One(select = "com.xiachao.mapper.PersonMapper.findPersonById"))
    })
    public List<Order> findAll();


    @Select("select * from orders where personId=#{personId}")
    public Order findOrderById(Integer id);

}
