package com.hkk.boottest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kang
 * @since 2020/7/13
 */
@Component
public class SayHello {

    @Autowired
    private LogTest logTest;

    public void sayHello() {
        logTest.logBefore();
        System.out.println("hello");
        logTest.logAfter();
    }

}
