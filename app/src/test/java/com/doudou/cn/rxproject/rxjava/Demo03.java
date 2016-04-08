package com.doudou.cn.rxproject.rxjava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by jinliang on 16-4-7.
 */
public class Demo03 {
    @Test
    public void testDemo03(){

        /**
         *     Observable.from("url1", "url2", "url3")
         .subscribe(url -> System.out.println(url));
         */

        List list = new ArrayList();
        for (int i = 0; i <3 ; i++){

            list.add(i+"");
        }
        Observable.from(list).subscribe(new Action1<String>(){

            @Override
            public void call(String s) {
                  System.out.println("call:" +s );
            }
        });
    }
}
