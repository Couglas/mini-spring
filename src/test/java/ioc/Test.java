package ioc;

import ioc.context.ClassPathXmlApplicationContext;
import ioc.service.SayService;

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
