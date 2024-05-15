package com.spring.test;

import com.spring.beans.BeansException;
import com.spring.context.ClassPathXmlApplicationContext;
import com.spring.test.service.SayService;


/**
 * 测试类
 *
 * @author couglas
 * @since 2024/5/13
 */
public class Test {
    public static void main(String[] args) throws BeansException {
//        SimpleClassPathXmlApplicationContext ctx = new SimpleClassPathXmlApplicationContext("beans.xml");
//        SayService sayService = (SayService) ctx.getBean("sayService");
//        sayService.sayHello();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        SayService saySer = (SayService) context.getBean("sayService");
        saySer.sayHello();
    }
}
