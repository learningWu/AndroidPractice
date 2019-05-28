package com.example.dzj.android_practice.concurrentdemo

import android.util.Log

import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * SynchronousQueue  可以更方便的通过阻塞，使某个线程在另一个线程之后顺序执行
 */
class SynchronousQueueTest {
    private val synchronousQueue = SynchronousQueue<Int>()
    private var runnedCount = 0;
    fun main() {
//        获得android 的四大线程池 FixedThreadPool  CachedThreadPool ScheduledThreadPool  SingledThreadPool
//                Executors.newSingleThreadExecutor(1)

        val threadPoolExecutor = ThreadPoolExecutor(10,
                Int.MAX_VALUE,
                1,
                TimeUnit.MINUTES,
                ArrayBlockingQueue<Runnable>(5), ThreadFactory { runnable ->
            val thread = Thread(runnable)
            thread.name = "name" + System.nanoTime()
            thread
        }
        )
        //预启动一个核心线程
        threadPoolExecutor.prestartAllCoreThreads();
        //预启动所有核心线程
        repeat(20) {
            threadPoolExecutor.execute(Thread1())
            Log.d("线程池信息", "core:" + threadPoolExecutor.corePoolSize + "count:" + threadPoolExecutor.poolSize)
        }
        //作用在多层循环时continue和break跳到指定循环位置
//        retry@ for (i in 0..4) {
//            threadPoolExecutor.execute(Thread2())
//            if (i == 3) {
//                break@retry
//            }
//
//        }
    }

    /**
     * internal 模块内 修饰符
     */
    private inner class Thread1 internal constructor() : Runnable {

        override fun run() {
            //            Log.d("Thread", "thread1");

            try {
                runnedCount++
                Log.d("Thread", "thread1" + "...runnedCount" + runnedCount);
                Thread.sleep(5000)
//                synchronousQueue.put(10)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

        }
    }

    private inner class Thread2 internal constructor() : Runnable {

        override fun run() {

            try {
                Log.d("Thread", "thread2")
//                val take = synchronousQueue.take()
//                Log.d("阻塞结束：", "等待其他线程结果出现" + take!!)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

        }
    }
}
