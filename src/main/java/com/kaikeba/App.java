package com.kaikeba;

import com.kaikeba.service.BaseService;
import com.kaikeba.service.impl.BaseServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        BaseService baseService = context.getBean(BaseServiceImpl.class);
        String login = baseService.login("yangw", "123456");
        System.out.println("login = " + login);
        List<String> strings = Collections.singletonList("");
    }
}
