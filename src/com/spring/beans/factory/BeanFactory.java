package com.spring.beans.factory;

import com.spring.beans.BeansException;
import com.spring.beans.factory.config.BeanDefinition;

/**
 * BeanFactory
 *
 * @author couglasF
 * @since 2024/5/14
 */
public interface BeanFactory {
    Object getBean(String beanName) throws BeansException;

    void registryBeanDefinition(BeanDefinition beanDefinition);
}
