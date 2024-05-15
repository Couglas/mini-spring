package com.spring.context;

import com.spring.beans.factory.config.BeanDefinition;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * xml解析
 *
 * @author couglas
 * @since 2024/5/13
 */
public class SimpleClassPathXmlApplicationContext {
    private final List<BeanDefinition> beanDefinitions = new ArrayList<>();
    private final Map<String, Object> singletons = new HashMap<>();

    public SimpleClassPathXmlApplicationContext(String fileName) {
        this.readXml(fileName);
        this.instanceBeans();
    }

    private void readXml(String fileName) {
        SAXReader saxReader = new SAXReader();

        try {
            URL xmlPath = this.getClass().getClassLoader().getResource(fileName);
            Document document = saxReader.read(xmlPath);
            Element rootElement = document.getRootElement();
            for (Element element : rootElement.elements()) {
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                BeanDefinition beanDefinition = new BeanDefinition(id, className);

                beanDefinitions.add(beanDefinition);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void instanceBeans() {
        for (BeanDefinition beanDefinition : beanDefinitions) {
            try {
                singletons.put(beanDefinition.getId(), Class.forName(beanDefinition.getClassName()).getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    public Object getBean(String beanName) {
        return singletons.get(beanName);
    }
}
