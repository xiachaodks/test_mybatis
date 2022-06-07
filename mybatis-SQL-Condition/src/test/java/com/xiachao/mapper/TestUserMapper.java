package com.xiachao.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiachao.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestUserMapper {

    InputStream resourceAsStream;

    {
        try {
            resourceAsStream = Resources.getResourceAsStream("MybatisConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();


    @Test
    public void testPageHelper() {
        //设置分页  当前页+每页显示的条数
        PageHelper.startPage(2, 3);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        //其他分页的数据
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("每页显示长度："+pageInfo.getPageSize());
        System.out.println("是否第一页："+pageInfo.isIsFirstPage());
        System.out.println("是否最后一页："+pageInfo.isIsLastPage());
    }

    @Test
    public void testFindAll() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.findAll());
    }

    @Test
    public void testFindUserById() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper.findUserById(1));
    }


    @Test
    public void testFindUserByCondition() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User condition = new User();
        condition.setUserName("田心宝贝");
        condition.setUserId(3);
        System.out.println(userMapper.findUserByCondition(condition));
    }

    @Test
    public void testFindUserByIds() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        ArrayList<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        idList.add(5);
        System.out.println(userMapper.findUserByIds(idList));
    }


}
