package com.spring.beans.factory.config;

/**
 * BeanDefinition仓库
 *
 * @author couglas
 * @since 2024/5/16
 */
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String name, BeanDefinition beanDefinition);

    void removeBeanDefinition(String name);

    BeanDefinition getBeanDefinition(String name);

    boolean containsBeanDefinition(String name);
}
