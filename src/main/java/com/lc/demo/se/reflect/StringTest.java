package com.lc.demo.se.reflect;

import lombok.Data;

import java.lang.reflect.Constructor;

@Data
public class StringTest {

    public String field1;

    public StringTest(String field1) {
        this.field1 = field1;
    }

    public StringTest() {
    }

    public static void main(String[] args) throws Exception{
        Class<StringTest> clz = StringTest.class;
        Constructor<StringTest> c1 = clz.getDeclaredConstructor();
        System.out.println(c1);
    }

    @Override
    public String toString() {
        return "test";
    }

    public void m() {
        System.out.println(this);
    }
}
