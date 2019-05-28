package com.example.dzj.android_practice.kotlindemo

import android.util.Log

class KotlinTest constructor(intA: Int? = null, intB: Int? = null) {
    var intA = 0


    /**
     * 操作符
     */
    operator fun get(int: Int): KotlinTest {
        Log.d("value", "" + int)
        return this
    }

    operator fun plus(int: Int): Int {
        intA += int
        Log.d("value", "" + intA)
        return intA
    }

    inline fun log() {
        print("log")
    }

    fun main() {
        log();
        KotlinTest()
        //循环数组，去除最后size的越界位置
        val arrayOf = arrayOf(1, 2, 3).apply {
            this[1]
        }

        for (i in 0 until arrayOf.size) {

        }

        defaultA(10)
        defaultA(10, 20)

    }

    //@JvmOverloads 重载给Java使用,否则java不能像  defaultA(10) 这样使用
    @JvmOverloads
    fun defaultA(a: Int, b: Int = 10) {
    }
}