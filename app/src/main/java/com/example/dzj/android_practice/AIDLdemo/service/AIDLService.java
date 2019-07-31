package com.example.dzj.android_practice.AIDLdemo.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.dzj.android_practice.IService;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.dzj.android_practice.model.User.user;

public class AIDLService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }

    private int count;
    IService.Stub stub = new IService.Stub() {
        @Override
        public String getData(String func, String params) throws RemoteException {
            Log.i("LEO", "接收到请求");
            Log.i("LEO", "func :" + func + "; params:" + params);
            JSONObject jsonObject = new JSONObject();
            switch (func) {
                case "char":
                    try {
                        user.name = "name" + count++;
                        jsonObject.put("name", user.name);
                        jsonObject.put("password", user.password);
                        long mills = System.currentTimeMillis();
                        jsonObject.put("time", mills);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
            return jsonObject.toString();
        }
    };
}
