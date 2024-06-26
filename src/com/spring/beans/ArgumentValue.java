package com.spring.beans;

/**
 * 参数类
 *
 * @author couglas
 * @since 2024/5/16
 */
public class ArgumentValue {
    private String type;
    private String name;
    private Object value;

    public ArgumentValue(String type, String name, Object value) {
        this.type = type;
        this.name = name;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
