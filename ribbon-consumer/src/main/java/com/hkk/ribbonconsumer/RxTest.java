package com.hkk.ribbonconsumer;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * @author kang
 * @since 2020/7/7
 */
public class RxTest {

    public static void main(String[] args) throws InterruptedException {
        Observable observable = Observable.create((OnSubscribe<String>) subscriber -> {
            System.out.println("Observable" + Thread.currentThread().getName());
            subscriber.onNext("Hello");
            subscriber.onNext("Hi");
            subscriber.onNext("Aloha");
            subscriber.onCompleted();
        });
        observable.subscribeOn(Schedulers.computation()).observeOn(Schedulers.io())
            .subscribe(new Subscriber() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(Object o) {
                    System.out.println("observer:" + Thread.currentThread().getName());
                    System.out.println(o);
                }

                @Override
                public void onStart() {
                    System.out.println("start");
                }
            });
        // 等待事件发送完成
        Thread.currentThread().join(1000);
    }

}
