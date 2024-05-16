package com.spring.beans.factory.config;

/**
 * 单例Bean注册接口
 *
 * @author couglas
 * @since 2024/5/15
 */
public interface SingletonBeanRegistry {
    void registerSingleton(String beanName, Object singletonObject);

    Object getSingleton(String beanName);

    boolean containsSingleton(String beanName);

    String[] getSingletonNames();

}
