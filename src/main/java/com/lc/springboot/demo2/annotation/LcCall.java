package com.lc.springboot.demo2.annotation;

public class LcCall {

    @Lc("my annotation")
    @SuppressWarnings("")
    public void callAnnotationLc() {
        System.out.println("test annotation");
    }
}
