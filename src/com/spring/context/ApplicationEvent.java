package com.spring.context;

import java.util.EventObject;

/**
 * 应用事件
 *
 * @author couglas
 * @since 2024/5/16
 */
public class ApplicationEvent extends EventObject {
    private static final long serialVersionID = 1L;
    public ApplicationEvent(Object arg0) {
        super(arg0);
    }
}
