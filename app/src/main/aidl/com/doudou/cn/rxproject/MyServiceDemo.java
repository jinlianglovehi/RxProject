package com.doudou.cn.rxproject;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by jinliang on 16-4-7.
 */
public class MyServiceDemo extends Service {

    private IBinder idateBinder = new IDataService.Stub(){

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return idateBinder;
    }


    private void test(){
       // (DeathRecipient recipient, int flags);
//        idateBinder.unlinkToDeath();

    }


}
