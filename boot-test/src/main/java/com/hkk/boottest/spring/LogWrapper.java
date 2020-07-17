package com.hkk.boottest.spring;

import com.hkk.boottest.spring.LogTest;

/**
 * @author kang
 * @since 2020/7/13
 */
public class LogWrapper implements LogTest {

    private LogTest logTest;

    public void setLog(LogTest logTest) {
        this.logTest = logTest;
    }

    @Override
    public void logBefore() {
        System.out.println("before-wrapper");
        logTest.logBefore();
    }

    @Override
    public void logAfter() {
        System.out.println("after-wrapper");
        logTest.logAfter();
    }
}
