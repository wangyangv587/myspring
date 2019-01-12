package com.kaikeba.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: Alex
 * @date: 2019/1/11 16:50
 * description:
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class TestJdbc {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test01(){
        //jdbcTemplate.update("INSERT INTO user (name,password) VALUES (?,?)","yangw1","123456");
        jdbcTemplate.update("UPDATE user SET password=? where name=?","123456","yangw");
    }
}
