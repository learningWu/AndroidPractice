package com.example.dzj.android_practice.otherdemo

import android.graphics.BitmapFactory
import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.util.Log

class BigBitmapTest {
    fun main(): Unit {
        val options = BitmapFactory.Options()
        caculateInSampleSize()
    }

    private fun caculateInSampleSize(): Int {
        val height = 1024
        val width = 480
        val requestHeight = 300
        val requestWidth = 250

        var inSampleSize = 1
        var halfHight = height
        var halfWidth = width
        while (halfHight  > requestHeight || halfWidth  > requestWidth) {
            inSampleSize = inSampleSize.shl(1)
            halfHight = halfHight.shr(1)
            halfWidth = halfWidth.shr(1)
            Log.d("BigBitmap：", "inSample:${inSampleSize}halfHight:${halfHight}halfWidth:${halfWidth}")
        }
        Log.d("BigBitmap：", "" + inSampleSize)
        return inSampleSize
    }
}