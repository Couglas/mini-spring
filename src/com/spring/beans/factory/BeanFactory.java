package beans.factory;

import beans.BeansException;
import beans.factory.config.BeanDefinition;

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
