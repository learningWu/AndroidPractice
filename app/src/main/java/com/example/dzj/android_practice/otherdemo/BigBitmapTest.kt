package com.example.dzj.android_practice.otherdemo

import android.graphics.BitmapFactory
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
        while ((halfHight / inSampleSize) > requestHeight || (halfWidth / inSampleSize) > requestWidth) {
            inSampleSize = inSampleSize.shl(2)
            halfHight = halfHight.shr(2)
            halfWidth = halfWidth.shr(2)
        }
        Log.d("BigBitmap：", "" + inSampleSize)
        return inSampleSize
    }
}