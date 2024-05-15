package com.spring.context;

import com.spring.beans.BeansException;
import com.spring.beans.factory.BeanFactory;
import com.spring.beans.factory.SimpleBeanFactory;
import com.spring.beans.factory.config.BeanDefinition;
import com.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.spring.core.ClassPathXmlResource;
import com.spring.core.Resource;

/**
 * xml解析应用上下文
 *
 * @author couglas
 * @since 2024/5/15
 */
public class ClassPathXmlApplicationContext implements BeanFactory {
    BeanFactory beanFactory;
    public ClassPathXmlApplicationContext(String fileName) {
        Resource resource = new ClassPathXmlResource(fileName);
        SimpleBeanFactory simpleBeanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(simpleBeanFactory);
        reader.loadBeanDefinition(resource);
        this.beanFactory = simpleBeanFactory;
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public void registryBeanDefinition(BeanDefinition beanDefinition) {
        this.beanFactory.registryBeanDefinition(beanDefinition);
    }
}
