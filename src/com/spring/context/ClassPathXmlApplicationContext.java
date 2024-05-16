package com.spring.context;

import com.spring.beans.BeansException;
import com.spring.beans.factory.BeanFactory;
import com.spring.beans.factory.SimpleBeanFactory;
import com.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.spring.core.ClassPathXmlResource;
import com.spring.core.Resource;

/**
 * xml解析应用上下文
 *
 * @author couglas
 * @since 2024/5/15
 */
public class ClassPathXmlApplicationContext implements BeanFactory, ApplicationEventPublisher {
    SimpleBeanFactory beanFactory;
    public ClassPathXmlApplicationContext(String fileName) {
        Resource resource = new ClassPathXmlResource(fileName);
        SimpleBeanFactory simpleBeanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(simpleBeanFactory);
        reader.loadBeanDefinition(resource);
        this.beanFactory = simpleBeanFactory;
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return this.beanFactory.getBean(name);
    }

    public void registryBean(String beanName, Object object) {
        this.beanFactory.registryBean(beanName, object);
    }

    @Override
    public boolean containsBean(String name) {
        return this.beanFactory.containsBean(name);
    }

    @Override
    public boolean isSingleton(String name) {
        return false;
    }

    @Override
    public boolean isPrototype(String name) {
        return false;
    }

    @Override
    public Class<?> getType(String name) {
        return null;
    }

    @Override
    public void publishEvent(ApplicationEvent event) {

    }
}
