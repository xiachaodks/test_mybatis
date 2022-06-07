package com.xiachao.mapper;

import com.xiachao.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUserMapper {

    private SqlSession sqlSession;
    private UserMapper mapper;

    @Before
    public void before() throws IOException {
        InputStream  resourceAsStream = Resources.getResourceAsStream("MybatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }


    @Test
    public void testFindAll(){
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindOrderById(){
        System.out.println(mapper.findUserById(1));
    }

    @Test
    public void testInsertOrder(){
        User user = new User();
        user.setUserId(11);
        user.setUserName("夏超");
        user.setGender("男");
        user.setAge(27);
        mapper.insertUser(user);
    }

    @Test
    public void testUpdateUser(){
        User user = mapper.findUserById(2);
        user.setUserName("tom");
        mapper.updateUser(user);
    }

    @Test
    public void testDeleteUser() {
        mapper.deleteUser(1);
    }

    @Test
    public void testFindAllUserAndRole(){
        List<User> list = mapper.findAllUserAndRole();
        for (User user : list) {
            System.out.println(user);
        }
    }


}
