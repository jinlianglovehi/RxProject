package com.doudou.cn.rxproject.rxjava;


import org.junit.Test;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by jinliang on 16-4-7.
 * 比较复杂的观察者和订阅者
 */
public class Demo01 {
    private final static String TAG = Demo01.class.getName();

    @Test
    public void test01() {
        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> sub) {
                        System.out.println("call");
                        // 异步任务或者是队列的内容；
                        sub.onNext("Hello, world!");
                    }
                }
        );
        //订阅者
        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                  System.out.println("onNext");
                System.out.println(s);
            }

            @Override
            public void onCompleted() {
                  System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                  System.out.println("onError");
            }
        };

//        myObservablble.subscribe(mySubscriber);


    }
}
