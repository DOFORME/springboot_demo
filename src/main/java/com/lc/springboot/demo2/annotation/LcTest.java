package com.lc.springboot.demo2.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author lc
 */
public class LcTest {

    private static final String CALL_ANNOTATION_LC = "callAnnotationLc";

    private static final String LC_ANNOTATION = "com.lc.springboot.demo2.annotation.Lc";

    public static void main(String[] args) throws Exception {
        Class lcCall = Class.forName("com.lc.springboot.demo2.annotation.LcCall");
        Method[] methods = lcCall.getMethods();

        for (Method m : methods) {
            String methodName = m.getName();
            if (CALL_ANNOTATION_LC.equals(methodName)) {
                Annotation[] annotations = m.getAnnotations();
                for (Annotation a : annotations) {
                    if (LC_ANNOTATION.equals(a.annotationType().getName())) {
                        System.out.println("simple name is " + a.annotationType().getSimpleName());
                        Lc lc = m.getAnnotation(Lc.class);
                        System.out.println("value is " + lc.value());
                    }
                }
            }
        }
    }
}
