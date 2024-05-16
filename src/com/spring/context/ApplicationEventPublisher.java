package com.spring.context;

/**
 * 应用事件发布
 *
 * @author couglas
 * @since 2024/5/16
 */
public interface ApplicationEventPublisher {
    void publishEvent(ApplicationEvent event);
}
