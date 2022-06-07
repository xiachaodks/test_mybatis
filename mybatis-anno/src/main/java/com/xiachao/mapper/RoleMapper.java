package com.xiachao.mapper;

import com.xiachao.pojo.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    @Select("select * from sys_role sr,sys_user_role sur where sr.roleId=sur.roleId " +
            "and sur.userId=#{userId}")
    public List<Role> findRoleByUserId(Integer userId);
}
