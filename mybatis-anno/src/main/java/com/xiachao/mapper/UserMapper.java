package com.xiachao.mapper;

import com.xiachao.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user where userId=#{userId}")
    public User findUserById(Integer userId);

    @Insert("insert into user values(#{userId},#{userName},#{gender},#{age})")
    public void insertUser(User user);

    @Update("update user set userName=#{userName},gender=#{gender} where userId=#{userId}")
    public void updateUser(User user);

    @Delete("delete from user where userId=#{userId}")
    public void deleteUser(Integer userId);

    //sys_user sys_role sys_user_role 多对多关系
    @Select("select * from sys_user")
    @Results({
            @Result(id = true,column = "userId",property = "userId"),
            @Result(column = "userName",property = "userName"),
            @Result(column = "gender",property = "gender"),
            @Result(column = "age",property = "age"),
            @Result(
                    column = "userId",
                    property = "roleList",
                    javaType = List.class,
                    many = @Many(select = "com.xiachao.mapper.RoleMapper.findRoleByUserId")
            )

    })
    public List<User> findAllUserAndRole();

}
