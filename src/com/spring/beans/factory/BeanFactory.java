package com.spring.beans.factory;

import com.spring.beans.BeansException;

/**
 * BeanFactory
 *
 * @author couglasF
 * @since 2024/5/14
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;

    boolean isSingleton(String name);

    boolean isPrototype(String name);

    Class<?> getType(String name);

    boolean containsBean(String name);

//    void registryBean(String beanName, Object object);

}
