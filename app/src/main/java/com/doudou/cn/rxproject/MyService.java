package com.doudou.cn.rxproject;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by jinliang on 16-4-7.
 */
public class MyService extends Service {
     private final static String TAG = MyService.class.getName();


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }
}
