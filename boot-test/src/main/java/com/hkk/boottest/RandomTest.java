package com.hkk.boottest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author kang
 * @since 2020/7/8
 */
public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();
        for(int i = 0 ; i< 10;i++){
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(random.nextInt());
            }).start();
        }
    }

}
