package com.example.dzj.android_practice.AIDLdemo

import android.util.Log
import com.example.dzj.android_practice.model.User.user
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class IpcTest {
    fun main(): Unit {
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(Runnable {
            Log.d("LEO", user.name)
        }, 1,1, TimeUnit.SECONDS)
    }
}