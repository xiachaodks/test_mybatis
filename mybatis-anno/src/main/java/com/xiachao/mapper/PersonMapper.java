package com.xiachao.mapper;

import com.xiachao.pojo.Order;
import com.xiachao.pojo.Person;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PersonMapper {

    @Select("select * from person")
    public List<Person> findAll();

    @Select("select * from person where personId=#{personId}")
    public Person findPersonById(Integer personId);

    @Select("select * from person")
    @Results({
            @Result(id = true,column = "personId",property = "personId"),
            @Result(column = "personName",property = "personName"),
            @Result(column = "birthday",property = "birthday"),
            @Result(
                    column = "personId",
                    property = "orderList",
                    javaType = List.class,
                    many = @Many(select = "com.xiachao.mapper.OrderMapper.findOrderById")),
    })
    public List<Person> findAllPersonAndOrders();

}
