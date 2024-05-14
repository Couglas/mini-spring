package ioc.service.impl;

import ioc.service.SayService;

/**
 * sayService实现类
 *
 * @author couglas
 * @since 2024/5/13
 */
public class SayServiceImpl implements SayService {
    @Override
    public void sayHello() {
        System.out.println("say hello!");
    }
}
