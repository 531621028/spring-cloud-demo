package com.hkk.boottest.mybatis;

import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaClass;

/**
 * @author kang
 * @since 2021/2/28
 */
public class MeatClassTest {

    private InnerClass innerClass;

    public static void main(String[] args) {
        MetaClass metaClass = MetaClass.forClass(MeatClassTest.class, new DefaultReflectorFactory());
        System.out.println(metaClass.findProperty("inNerClaSs.a"));

    }

    public static class InnerClass{
        private int a;
    }

}
