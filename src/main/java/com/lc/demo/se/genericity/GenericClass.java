package com.lc.demo.se.genericity;

import com.lc.demo.springboot.entity.pojo.Student;

public class GenericClass<T> {

    private T field1;

    public static void main(String[] args) {
        showGenericType();
        genericMethod(1);
        testSwap();
        String str = "hello";
        swap(str);
        System.out.println(str);
    }

    private static void showGenericType() {
        GenericClass<String> gcs = new GenericClass<>();
        gcs.setField1("abc");
        System.out.println(gcs.field1.getClass());
        System.out.println(gcs.getField1());

        genericMethod("abc");
    }

    public T getField1() {
        return field1;
    }

    public void setField1(T field1) {
        this.field1 = field1;
    }

    public static <T> void genericMethod(T t) {
        System.out.println("方法类型为：" + t.getClass());
    }

    public static void testSwap() {
        Integer x = 500;
        Integer y = 600;
        Student s = new Student();
        swap(x, y);

        s.setName("old");
        swap(s);
        System.out.println(s);

        StringBuilder sb = new StringBuilder("new sb");
        swap(sb);
        System.out.println(sb);
    }

    private static void swap(Integer x, Integer y) {
        int temp = x;
        x = y;
        y = temp;
    }

    private static void swap(String str) {
        str = "java";
    }

    private static void swap(Student student) {
        Student s = new Student();
        s.setName("new");
        student = s;
    }

    private static void swap(StringBuilder sb) {
        sb = new StringBuilder("new sb");
        sb.append("++");
    }
}
