package com.kaikeba.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mybatis-spring/spring-*.xml")
@PropertySource("classpath:application.properties")
public class AccountServiceTest {

    @Autowired
    private AccountService service;

    @Test
    public void transfer(){
        service.transfer("老公","老婆",100);
    }

}