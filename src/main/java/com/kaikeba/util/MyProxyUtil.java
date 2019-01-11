package com.kaikeba.util;

import com.kaikeba.service.BaseService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: Alex
 * @date: 2019/1/11 11:17
 * description:
 */
public class MyProxyUtil {

    public BaseService getProxy(final BaseService service){

        BaseService instance = (BaseService)Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("增加之前。。。");
                Object object = method.invoke(service, args);
                System.out.println("增加后前。。。");
                return object;
            }
        });
        return instance;
    }
}
