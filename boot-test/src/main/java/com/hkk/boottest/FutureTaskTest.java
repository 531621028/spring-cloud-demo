package com.hkk.boottest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author kang
 * @since 2020/7/15
 */
public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = () -> {
            TimeUnit.SECONDS.sleep(10);
            return "done";
        };
        FutureTask<String> task = new FutureTask<>(callable);
        new Thread(task).start();
        System.out.println(task.get());
    }
}
