package com.example.dzj.android_practice.jnidemo;

import android.util.Log;

public class JniTest {
    static {
        System.loadLibrary("jnitest");
    }

    public char name = 'w';

    public void main() {
        nativeFunc();
    }

    public void javaFunc() {
        Log.d(name + "", "java 方法");
    }

    public native void nativeFunc();
}
