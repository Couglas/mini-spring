package com.spring.beans.factory;

import com.spring.beans.*;
import com.spring.beans.factory.config.BeanDefinition;
import com.spring.beans.factory.config.BeanDefinitionRegistry;
import com.spring.beans.factory.support.DefaultSingletonBeanRegistry;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 简单BeanFactory实现类
 *
 * @author couglas
 * @since 2024/5/15
 */
public class SimpleBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory, BeanDefinitionRegistry {
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
    private List<String> beanDeinitionNames = new ArrayList<>();
    public SimpleBeanFactory() {

    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(name, beanDefinition);
        this.beanDeinitionNames.add(name);
        if (!beanDefinition.isLazyInit()) {
            try {
                getBean(name);
            } catch (BeansException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Object getBean(String beanName) throws BeansException {
        Object singleton = this.getSingleton(beanName);
        if (singleton == null) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            singleton = createBean(beanDefinition);
            this.registryBean(beanName, singleton);
            if (beanDefinition.getInitMethodName() != null) {
                // init method
            }
        }
        if (singleton == null) {
            throw new BeansException("bean is null!");
        }
        return singleton;
    }

    private Object createBean(BeanDefinition bd) {
        Class<?> clazz;
        Object obj;
        Constructor<?> con;

        try {
            clazz = Class.forName(bd.getClassName());
            // hanlde contructor
            ArgumentValues argumentValues = bd.getConstructorArgumentValues();
            int argumentCount = argumentValues.getArgumentCount();
            if (!argumentValues.isEmpty()) {
                Class<?>[] paramTypes = new Class<?>[argumentCount];
                Object[] paramValues = new Object[argumentCount];
                for (int i = 0; i < argumentCount; i++) {
                    ArgumentValue argumentValue = argumentValues.getIndexedArgumentValue(i);
                    String type = argumentValue.getType();
                    if ("Integer".equals(type) || "java.lang.Integer".equals(type)) {
                        paramTypes[i] = Integer.class;
                        paramValues[i] = Integer.valueOf((String) argumentValue.getValue());
                    }
                    else if ("int".equals(type)) {
                        paramTypes[i] = int.class;
                        paramValues[i] = Integer.valueOf((String) argumentValue.getValue()).intValue();
                    }
                    else {
                        paramTypes[i] = String.class;
                        paramValues[i] = argumentValue.getValue();
                    }
                }
                con = clazz.getConstructor(paramTypes);
                obj = con.newInstance(paramValues);
            }
            else {
                obj = clazz.newInstance();
            }

            // handle properties
            PropertyValues propertyValues = bd.getPropertyValues();
            if (!propertyValues.isEmpty()) {

                Object[] paramValues = new Object[1];
                for (int i = 0; i < propertyValues.size(); i++) {
                    PropertyValue propertyValue = propertyValues.getPropertyValueList().get(i);
                    String name = propertyValue.getName();
                    String type = propertyValue.getType();
                    Object value = propertyValue.getValue();

                    Class<?>[] paramTypes = new Class<?>[1];
                    if ("Integer".equals(type) || "java.lang.Integer".equals(type)) {
                        paramTypes[0] =  Integer.class;
                        paramValues[0] = Integer.valueOf((String) value);
                    }
                    else if ("int".equals(type)) {
                        paramTypes[0] = int.class;
                        paramValues[0] = Integer.valueOf((String) value).intValue();
                    }
                    else {
                        paramTypes[0] = String.class;
                        paramValues[0] = value;
                    }

                    String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                    Method method = clazz.getMethod(methodName, paramTypes);
                    method.invoke(obj, paramValues);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return obj;
    }

    public void registryBean(String beanName, Object object) {
        this.registerSingleton(beanName, object);
    }

    @Override
    public boolean containsBean(String name) {
        return containsSingleton(name);
    }

    @Override
    public void removeBeanDefinition(String name) {
        this.beanDefinitionMap.remove(name);
        this.beanDeinitionNames.remove(name);
        this.removeSingleton(name);
    }

    @Override
    public BeanDefinition getBeanDefinition(String name) {
        return this.beanDefinitionMap.get(name);
    }

    @Override
    public boolean containsBeanDefinition(String name) {
        return this.beanDefinitionMap.containsKey(name);
    }

    @Override
    public boolean isSingleton(String name) {
        return this.beanDefinitionMap.get(name).isSingleton();
    }

    @Override
    public boolean isPrototype(String name) {
        return this.beanDefinitionMap.get(name).isPrototype();
    }

    @Override
    public Class<?> getType(String name) {
        return this.beanDefinitionMap.get(name).getClass();
    }

}
