package com.kaikeba.config.spring;

import com.kaikeba.service.BaseService;
import com.kaikeba.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@PropertySource("classpath:application.properties")
@Configuration
public class SpringConfig {

    public SpringConfig(){
        System.out.println("配置容器初始化");
    }

    @Scope("prototype")
    @Bean
    public BaseService baseService(){
        return new BaseServiceImpl();
    }

}
