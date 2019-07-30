package com.eddie.client.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.dzj.android_practice.IService;


public class AIDLUtil {
    private static AIDLUtil aidlUtil;
    private IService iService;

    private AIDLUtil() {
    }

    public static AIDLUtil getInstance() {
        if (null == aidlUtil) {
            synchronized (AIDLUtil.class) {
                if (null == aidlUtil) {
                    aidlUtil = new AIDLUtil();
                }
            }
        }
        return aidlUtil;
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("LEO", "绑定成功");
            iService = IService.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            iService = null;
        }
    };

    public void bindService(Context context) {
        Intent intent = new Intent("com.example.dzj.android_practice");
        // 自己模块，aidl 所处的包名
        intent.setPackage("com.example.dzj.android_practice");
        context.bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    public void unbindService(Context context) {
        if (null == iService) {
            return;
        }
        Log.i("LEO", "取消绑定");
        context.unbindService(connection);
        iService = null;
    }

    public String request(@NonNull String func, @NonNull String params) {
        if (null == iService) {
            Log.i("LEO", "iService为null");
            return null;
        }
        Log.i("LEO", "发起AIDL请求");
        try {
            String data = iService.getData(func, params);
            return data;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
