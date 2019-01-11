package com.kaikeba.service.impl;

import com.kaikeba.service.BaseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service("baseService")
@PropertySource("classpath:application.properties")
public class BaseServiceImpl implements BaseService {

    @Value("${root.name}")
    private String name;

    @Value("${root.password}")
    private String password;

    @Value("${test.id}")
    private String id;

    @Override
    public String login(String name, String password) {
        if (name.equals(this.name) && password.equals(this.password)) {
            return "登录成功";
        }
        return "登录失败";
    }

    @Override
    public void saveUser() {
        System.out.println("save user" + id);
    }
}
