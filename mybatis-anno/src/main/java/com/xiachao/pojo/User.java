package com.xiachao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private String gender;
    private Integer age;


    //同一个User对应多个Role
    //User与Role是多对多的关系
    private List<Role> roleList;
}
