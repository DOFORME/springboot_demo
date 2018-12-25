package com.lc.demo.se.reflect;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
public class ReflectBean implements Serializable, Comparable {

    private String field;

    private void method1() {
        System.out.println("方法1");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public ReflectBean(String field) {
        this.field = field;
    }

    public ReflectBean() {
    }
}
