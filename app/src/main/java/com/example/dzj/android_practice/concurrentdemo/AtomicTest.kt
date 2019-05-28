package com.example.dzj.android_practice.concurrentdemo

import android.util.Log
import java.util.concurrent.atomic.AtomicInteger

class AtomicTest {

    var atomicInteger = AtomicInteger()
    var intA = 0


    fun main() {
        repeat(100) {
            Thread1().start()
        }
    }

    inner class Thread1 : Thread() {
        override fun run() {
            atomicInteger.getAndIncrement()
            intA++
            Log.d("AtomicTest:", "atomicInteger：" + atomicInteger.get())
            Log.d("AtomicTest:", "intA：" + intA)
        }
    }
}