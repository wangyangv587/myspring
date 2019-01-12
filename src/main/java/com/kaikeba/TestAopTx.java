package com.kaikeba;

import com.kaikeba.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-tx.xml")
public class TestAopTx {

    @Resource
    private AccountService accountService;

    @Test
    public void test01(){
        accountService.register("老公",1300);
        accountService.register("老婆",400);
        accountService.register("测试",1000);
    }

    @Test
    public void test02(){
        accountService.transfer("老公","老婆",100);
    }
}
