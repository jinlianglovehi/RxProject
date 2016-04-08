package com.doudou.cn.rxproject.rxjava;

import android.content.SyncStatusObserver;

import org.junit.Test;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;


/**
 * Created by jinliang on 16-4-7.
 * 简介的 rxjava 调用的方式
 */
public class Demo02 {
    @Test
    public void testDemo02() {

        // 第一种方案：
        Observable<String> myobservable = Observable.just("Hello wolrd");

        Action1<String> nextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("call Method:" + s);
            }
        };

        myobservable.subscribe(nextAction);


        //第二种方案
        Observable.just("second world").subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(" 订阅 :" + s);

            }
        });


        System.out.println("--------------------------------------");
        // 第三种方案：

        /**
         *
         *  new Fun1 函数中 第一个参数： 传入参数， 第二个参数位 返回参数。
         *
         *
         */
        Observable.just("第三种方案").map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                System.out.println("----Func1 Mthod---");
                return "添加前缀：" + s + "--第三种方案-- Fun1 -Method -";
            }
        }).subscribe(new Action1<String>() {

            @Override
            public void call(String s) {
                System.out.println("-----Action call ----");
                System.out.println(s + "--第三种方案 -- Action1  Method--");

            }
        });

          System.out.println("-----------------------------------------");
        Observable.just("第三套方案 订阅三个参数").map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                System.out.println("----Func1 Mthod---");
                return "添加前缀：" + s + "--第三种方案-- Fun1 -Method -";
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                  System.out.println("--call---");

            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                System.out.println("--error---");
            }
        }, new Action0() {
            @Override
            public void call() {
                System.out.println("--complete---");
            }
        });


    }
}
