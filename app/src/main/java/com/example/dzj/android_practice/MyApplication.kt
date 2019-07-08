package com.example.dzj.android_practice

import android.app.Application
import com.facebook.soloader.SoLoader

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // 初始化
        SoLoader.init(this, false)
    }
}