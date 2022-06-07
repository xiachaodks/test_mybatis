package com.xiachao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Integer userId;
    private String userName;
    private String gender;
    private Integer age;
}
