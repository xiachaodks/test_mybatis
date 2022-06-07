package com.xiachao.mapper;

import com.xiachao.pojo.User;

import java.util.List;

public interface UserMapper {

    public List<User> findAll();

    public User findUserById(Integer userId);

    public List<User> findUserByCondition(User user);

    public List<User> findUserByIds(List<Integer> userIds);
}
