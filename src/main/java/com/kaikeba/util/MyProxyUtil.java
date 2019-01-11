package com.kaikeba.util;

import com.kaikeba.service.BaseService;
import com.kaikeba.service.impl.BaseServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: Alex
 * @date: 2019/1/11 11:17
 * description:
 */
public class MyProxyUtil {

    /**
     * 使用jdk实现动态代理
     * 基于接口
     * @param service
     * @return
     */
    public static BaseService getProxyByJDK(final BaseService service){

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

    /**
     * 使用cglib实现动态代理
     * 基于继承
     * @return
     */
    public static BaseService getProxyByCglib(){

        //创建增强器
        Enhancer enhancer = new Enhancer();

        //设置需要增强的类对象
        enhancer.setSuperclass(BaseServiceImpl.class);

        //设置回调函数
        enhancer.setCallback(new MethodInterceptor() {

            //methodProxy：代理之后的对象的方法引用
            @Override
            public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib增强之前。。。");
                Object invoke = methodProxy.invokeSuper(object, args);
                System.out.println("cglib增强之后。。。");
                return invoke;
            }
        });


        return (BaseService)enhancer.create();
    }
}
