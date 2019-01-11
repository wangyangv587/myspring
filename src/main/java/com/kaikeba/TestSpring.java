package com.kaikeba;


import com.kaikeba.config.spring.SpringConfig;
import com.kaikeba.service.BaseService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {

    BaseService baseService;

    @Before
    public void init(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        baseService = context.getBean(BaseService.class);
    }

    @Test
    public void test1(){
        baseService.saveUser();
    }
}
