package com.spring.test.service.impl;


import com.spring.test.service.SayService;

/**
 * sayService实现类
 *
 * @author couglas
 * @since 2024/5/13
 */
public class SayServiceImpl implements SayService {
    private String property1;
    private Integer property2;
    private String name;
    private int level;

    public SayServiceImpl() {

    }

    public SayServiceImpl(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getProperty1() {
        return property1;
    }

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    public Integer getProperty2() {
        return property2;
    }

    public void setProperty2(Integer property2) {
        this.property2 = property2;
    }

    @Override
    public void sayHello() {
        System.out.println("say hello!");
    }

    @Override
    public String toString() {
        return "SayServiceImpl{" +
                "property1='" + property1 + '\'' +
                ", property2=" + property2 +
                ", name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
