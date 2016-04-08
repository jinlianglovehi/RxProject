package com.doudou.cn.rxproject.service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.doudou.cn.rxproject.IAddData;

/**
 * Created by jinliang on 16-4-8.
 * 服务器的接受相应的内容
 */
public class ServerService  extends Service{
 private final static String TAG = ServerService.class.getName();

    private IBinder addBinder = new IAddData.Stub(){


        @Override
        public int basicTypes(int a, int b) throws RemoteException {
            return a +b;
        }
    } ;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: ");
        Log.i(TAG, "onBind: 获取Ibinder的状态："+ addBinder.isBinderAlive());
        return addBinder;
    }

    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        Log.i(TAG, "bindService: ");
        return super.bindService(service, conn, flags);
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        super.unbindService(conn);
        Log.i(TAG, "unbindService: ");
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        super.onDestroy();
    }
}
