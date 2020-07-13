package com.hkk.boottest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kang
 * @since 2020/7/13
 */
@Component
public class LogTestImpl implements  LogTest{


    @Autowired
    private SayHello sayHello;

    @Override
    public void logBefore() {
        System.out.println("before");
    }

    @Override
    public void logAfter() {
        System.out.println("after");
    }
}
