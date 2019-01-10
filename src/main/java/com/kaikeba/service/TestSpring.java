package com.kaikeba.service;


import com.kaikeba.config.spring.SpringConfig;
import com.kaikeba.service.impl.BaseServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BaseService baseService1 = context.getBean(BaseService.class);
        System.out.println("baseService1 = " + baseService1);
        BaseService baseService2 = (BaseService)context.getBean("baseService");
        System.out.println("baseService2 = " + baseService2);
        baseService1.saveUser();
        baseService2.saveUser();
    }
}
