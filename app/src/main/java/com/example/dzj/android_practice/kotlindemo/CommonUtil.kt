package com.example.dzj.android_practice.kotlindemo

import android.content.res.Resources

fun dpToPx(dp:Int): Float = Resources.getSystem().displayMetrics.density * dp

val <T> List<T>.lastData:T
get() {
    return this[size-1]
}