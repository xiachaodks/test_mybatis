package com.xiachao;

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
    SqlSession sqlSession = sqlSessionFactory.openSession(true);

    @Test
    public void testFindAll(){

        List<User> userList = sqlSession.selectList("userMapper.findAll");
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
