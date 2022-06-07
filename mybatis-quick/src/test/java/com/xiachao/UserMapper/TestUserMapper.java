package com.xiachao.UserMapper;

import com.xiachao.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
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
    public void testFindAll(){

        List<Object> list = sqlSession.selectList("userMapper.findAll");
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void testFindUserById(){

        User user = sqlSession.selectOne("userMapper.findUserById",1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testInsertUser() {
        User user = new User(3,"lisi","男",18);
        sqlSession.insert("userMapper.insertUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateUser() {
        User user = new User(3,"甜心","女",18);
        sqlSession.update("userMapper.updateUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteUser() {
        String deleteUserName = "tianxin";
        sqlSession.delete("userMapper.deleteUser",deleteUserName);
        sqlSession.commit();
        sqlSession.close();
    }
}
