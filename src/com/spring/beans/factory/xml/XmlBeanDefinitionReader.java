package com.spring.beans.factory.xml;

import com.spring.beans.ArgumentValue;
import com.spring.beans.ArgumentValues;
import com.spring.beans.PropertyValue;
import com.spring.beans.PropertyValues;
import com.spring.beans.factory.SimpleBeanFactory;
import com.spring.beans.factory.config.BeanDefinition;
import com.spring.core.Resource;
import org.dom4j.Element;

import java.util.List;

/**
 * xml转
 *
 * @author couglas
 * @since 2024/5/15
 */
public class XmlBeanDefinitionReader {
    SimpleBeanFactory simpleBeanFactory;

    public XmlBeanDefinitionReader(SimpleBeanFactory simpleBeanFactory) {
        this.simpleBeanFactory = simpleBeanFactory;
    }

    public void loadBeanDefinition(Resource resource) {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanId = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanId, beanClassName);

            List<Element> propertyElements = element.elements("property");
            PropertyValues propertyValues = new PropertyValues();
            for (Element e : propertyElements) {
                String type = e.attributeValue("type");
                String name = e.attributeValue("name");
                String value = e.attributeValue("value");
                propertyValues.addPropertyValue(new PropertyValue(type, name, value));
            }
            beanDefinition.setPropertyValues(propertyValues);
            List<Element> constructorElements = element.elements("constructor-arg");
            ArgumentValues argumentValues = new ArgumentValues();
            for (Element e : constructorElements) {
                String type = e.attributeValue("type");
                String name = e.attributeValue("name");
                String value = e.attributeValue("value");
                argumentValues.addArgumentValue(new ArgumentValue(type, name, value));
            }
            beanDefinition.setConstructorArgumentValues(argumentValues);

            this.simpleBeanFactory.registerBeanDefinition(beanId, beanDefinition);
        }
    }
}
