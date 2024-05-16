package com.spring.test;

import com.spring.beans.BeansException;
import com.spring.context.ClassPathXmlApplicationContext;
import com.spring.context.SimpleClassPathXmlApplicationContext;
import com.spring.test.service.SayService;
import com.spring.test.service.impl.SayServiceImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * 测试类
 *
 * @author couglas
 * @since 2024/5/13
 */
public class Test {
    public static void main(String[] args) throws BeansException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
//        SimpleClassPathXmlApplicationContext ctx = new SimpleClassPathXmlApplicationContext("beans.xml");
//        SayService sayService = (SayService) ctx.getBean("sayService");
//
//        System.out.println(sayService);

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        SayService sayService = (SayService) context.getBean("sayService");

        System.out.println(sayService);
        sayService.sayHello();

    }
}
