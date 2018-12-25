package com.lc.demo.se.reflect;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Arrays;

@Slf4j
public class ReflectTest {

    private static final String REFLECT_BEAN_FULL_NAME = "com.lc.demo.se.reflect.ReflectBean";

    public static void main(String[] args) throws Exception {

//        testDiffMethodOfGetClass();
//        testGetSuperClassAndInterface();
//        testGetAllConstructor();
        testGetClassAllMsg();
    }

    private Class getClassByFullName(String className) {
        Class clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    private static void testDiffMethodOfGetClass() throws Exception {
        Class cla1 = null;
        Class cla2 = null;
        Class cla3 = null;

        cla1 = Class.forName(REFLECT_BEAN_FULL_NAME);
        cla2 = new ReflectBean().getClass();
        cla3 = ReflectBean.class;

        log.warn("class1:{}, class2:{}, class3:{}", cla1, cla2, cla3);
    }

    private static void testGetSuperClassAndInterface() throws Exception {
        Class clz = Class.forName(REFLECT_BEAN_FULL_NAME);

        log.warn("class's super class is :{}, implements interface has :{}", clz.getSuperclass(), Arrays.toString(clz.getInterfaces()));
    }

    private static void testGetAllConstructor() throws Exception {
        Class clz = Class.forName(REFLECT_BEAN_FULL_NAME);
        Constructor[] constructors = clz.getConstructors();
        for (Constructor c : constructors) {
            log.warn(c.getName());
            log.warn("parameter types has :{}", Arrays.toString(c.getParameterTypes()));

            Parameter[] ps = c.getParameters();
            if (ps != null) {
                for (Parameter p : ps) {
                    log.warn("constructor param :{}", p.getName());
                    log.warn(p.toString());
                    log.warn(Arrays.toString(p.getDeclaredAnnotations()), Arrays.toString(p.getAnnotations()));
                }
            }
        }

        ReflectBean bean = (ReflectBean) clz.newInstance();
        bean.setField("test");
        log.warn(new Gson().toJson(bean));
    }

    private static void testGetClassAllMsg() throws Exception {
        Class clz = Class.forName(REFLECT_BEAN_FULL_NAME);
        Package p = clz.getPackage();
        String simpleName = clz.getSimpleName();


        log.warn("simple name:{}", simpleName);

    }
}
