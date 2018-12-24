package com.lc.springboot.demo2.reflect;

import lombok.Data;

@Data
public class StringTest2 extends StringTest {

    String f;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        StringTest2 st = new StringTest2();
        st.toString("ag");
    }

    public String toString(Object o) {
        System.out.println(o.getClass());
        return o.toString();
    }

    public void f() {
        System.out.println("f");
    }

}
