package com.hkk.boottest;

import java.util.concurrent.locks.LockSupport;

/**
 * @author kang
 * @since 2020/7/9
 */
public class LockSupportTest {
    public void testPark(){
        LockSupport.park(this);
    }

    public static void main(String[] args) {
        new LockSupportTest().testPark();
    }

}
