package com.kaikeba.advice;

/**
 * @author: Alex
 * @date: 2019/1/11 14:42
 * description:
 */
public class MyAdvice {

    public void log(){
        System.out.println("记录日志：" + System.currentTimeMillis());
    }

    public void log2(){
        System.out.println("记录日志22：" + System.currentTimeMillis());
    }

    public void log3(){
        System.out.println("记录日志333：" + System.currentTimeMillis());
    }

    public void log4(){
        System.out.println("记录日志444：" + System.currentTimeMillis());
    }
}
