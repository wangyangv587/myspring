package com.kaikeba;

import com.kaikeba.config.spring.SpringConfig;
import com.kaikeba.config.spring.SpringConfig1;
import com.kaikeba.service.BaseService;
import com.kaikeba.util.MyProxyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author: Alex
 * @date: 2019/1/11 10:20
 * description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class TestSpring1 {

    @Resource
    private BaseService baseService;

    @Test
    public void test1(){
        baseService.saveUser();
    }

    @Test
    public void test2(){
        baseService.saveUser();

        System.out.println("------------------");

        BaseService proxy = MyProxyUtil.getProxyByJDK(baseService);
        proxy.saveUser();
    }

    @Test
    public void test3(){
        baseService.saveUser();

        System.out.println("------------------");

        BaseService proxy = MyProxyUtil.getProxyByCglib();
        proxy.saveUser();
    }

    @Test
    public void test4(){
        baseService.saveUser();
    }
}
