package com.kaikeba.service.impl;

import com.kaikeba.service.BaseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service("baseService")
public class BaseServiceImpl implements BaseService {

    @Value("${name}")
    private String name;

    @Value("${password}")
    private String password;

    @Value("${id}")
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
