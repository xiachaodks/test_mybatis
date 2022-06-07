package com.xiachao.mapper;

import com.xiachao.pojo.Order;
import com.xiachao.pojo.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestPersonMapper {

    private SqlSession sqlSession;
    private PersonMapper mapper;

    @Before
    public void before() throws IOException {
        InputStream  resourceAsStream = Resources.getResourceAsStream("MybatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);
         mapper = sqlSession.getMapper(PersonMapper.class);
    }

    @Test
    public void testFindAll(){
        List<Person> personList = mapper.findAll();
        for (Person person : personList) {
            System.out.println(person);
        }
    }

    @Test
    public void testFindAllPersonAndOrders(){
        List<Person> list = mapper.findAllPersonAndOrders();
        for (Person person : list) {
            System.out.println(person);
        }
    }
}
