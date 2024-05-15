package com.spring.beans.factory.xml;

import com.spring.beans.factory.BeanFactory;
import com.spring.beans.factory.config.BeanDefinition;
import com.spring.core.Resource;
import org.dom4j.Element;

/**
 * xml转
 *
 * @author couglas
 * @since 2024/5/15
 */
public class XmlBeanDefinitionReader {
    BeanFactory beanFactory;

    public XmlBeanDefinitionReader(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void loadBeanDefinition(Resource resource) {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanId = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanId, beanClassName);
            this.beanFactory.registryBeanDefinition(beanDefinition);
        }
    }
}
