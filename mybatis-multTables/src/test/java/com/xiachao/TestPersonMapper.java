package com.xiachao;

import com.xiachao.mapper.PersonMapper;
import com.xiachao.pojo.Order;
import com.xiachao.pojo.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestPersonMapper {

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
        List<Person> personList = sqlSession.selectList("PersonMapper.findAll");
        for (Person person : personList) {
            System.out.println(person);
        }
    }
}
