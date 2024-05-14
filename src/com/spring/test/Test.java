package test;

import context.ClassPathXmlApplicationContext;
import test.service.SayService;

/**
 * 测试类
 *
 * @author couglas
 * @since 2024/5/13
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        SayService sayService = (SayService) ctx.getBean("sayService");
        sayService.sayHello();
    }
}
