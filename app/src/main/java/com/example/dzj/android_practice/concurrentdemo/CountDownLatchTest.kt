package com.example.dzj.android_practice.concurrentdemo

import android.util.Log

import java.util.concurrent.CountDownLatch

/**
 * CountDownLatch 用于 控制某个线程的操作需要在其他线程有结果后执行，如A请求的参数是B请求和C请求的结果
 */
class CountDownLatchTest {


    fun main() {
        val countDownLatch = CountDownLatch(5)
        repeat(5) {
            val thread = Thread(Thread1(countDownLatch))
            thread.start()
        }

        repeat(5) {
            val thread = Thread(Thread2(countDownLatch))
            thread.start()
        }
    }

    private inner class Thread1 internal constructor(internal var countDownLatch: CountDownLatch) : Runnable {

        override fun run() {
            Log.d("CountDownLatch : ", "thread1")
            countDownLatch.countDown()
        }
    }

    private inner class Thread2 internal constructor(internal var countDownLatch: CountDownLatch) : Runnable {

        override fun run() {
            try {
                countDownLatch.await()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            Log.d("CountDownLatch : ", "thread2")
        }
    }
}

